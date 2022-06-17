package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Grass.Plant;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Interfaces.Breeding;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Interfaces.Eating;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Interfaces.Moving;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.Luck;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.Randomizer;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public abstract class Animal extends Creature implements Moving, Eating, Breeding {


    protected int starve = 3;
    protected List<Cell> accessibleCells = new ArrayList<>();


    public Animal(Coordinates position) {
        super(position);
        this.initializeAccessibleCells();
    }
    public Animal (int x, int y) {
        super(new Coordinates(x, y));
        initializeAccessibleCells();
    }

    @Override
    public void moveTo(Cell newCell) {
        reduceEnergy();
        if (getCurrentEnergy().get() < 0) {
            throw new RuntimeException("Нет доступных очков хода");
        }
        leaveCell();
        newCell.addAnimalInCell(this);
        setPosition(newCell.getCoordinates());
        initializeAccessibleCells();
    }


    @Override
    public void breed() {
        List<Animal> breeders = chooseForBreed();
        if (!breeders.isEmpty()) {
            Animal animal = breeders.get(Randomizer.randomize(0, breeders.size()));
            try {
                Island.instance.addAnimal(this.getClass().getConstructor(Coordinates.class).newInstance(this.getPosition()));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
            animal.reduceEnergy();
            this.reduceEnergy();
        } else {
            moveTo(choosingDirectionForBreed());
        }
    }
    public abstract Cell choosingDirectionForEat();

    public Cell choosingDirectionForBreed() {
        return getAccessibleCells().stream()
                .filter(e -> e.getCurrentCapacityOfCell()
                        .containsKey(getName()))
                .findFirst()
                .orElse(accessibleCells.get(Randomizer.randomize(0, accessibleCells.size())));

    }
    public List<Animal> chooseForBreed() {
        Cell cell = Island.instance.getCell(getPosition());
        return cell.getFauna().stream().filter(e -> e.getName().equals(getName())
                && !(e.equals(this)) && e.getCurrentEnergy().get() > 0).toList();
    }

    public Animal chooseVictim(List<Animal> accessibleAnimals) {
        Cell cell = Island.instance.getCell(this.getPosition());

        return accessibleAnimals.stream()
                .max(Comparator.comparing(Creature::getWeight))
                .orElse(accessibleAnimals.get(Randomizer.randomize(0, accessibleAnimals.size())));
    }

    public void tryToEat(Animal victim) {
        Integer luck = Luck.getLuck(this.getClass().getAnnotation(LuckNumber.class).value(), victim.getClass().getAnnotation(LuckNumber.class).value());
        if (ThreadLocalRandom.current().nextInt(0, 101) < luck) {
           // System.out.println(String.format("%s съел %s", this.getName(), victim.getName()));
            this.currentHanger += victim.getWeight();
            this.setStarve(3);
            if (this.currentHanger > this.maxHunger) {
                this.currentHanger = this.maxHunger;
            }
            victim.die();
        }
    }
    private void initializeAccessibleCells() {
        accessibleCells.clear();
        Coordinates coordinates = this.getPosition();

        if (coordinates.getX() - 1 >= 0) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX() - 1, coordinates.getY()));
        }
        if (coordinates.getY() - 1 >= 0) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX(), coordinates.getY() - 1));
        }
        if ((coordinates.getX() + 1) < Island.instance.getXSize()) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX() + 1, coordinates.getY()));
        }
        if (coordinates.getY() + 1 < Island.instance.getYSize()) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX(), coordinates.getY() + 1));
        }
    }

    @Override
    public void leaveCell() {
            Cell cell =  Island.instance.getCell(this.getPosition());
        cell.getFauna().remove(this);
        cell.getCurrentCapacityOfCell().merge(getName(), 1, Integer::sum);

        if (cell.getCurrentCapacityOfCell().get(getName()) >= getClass().getAnnotation(MaxCapacity.class).value()) {
            cell.getCurrentCapacityOfCell().remove(getName());
        }
        cell.removeThis(this);
    }

    public void act() {
        if (getCurrentHanger() < getMaxHunger() * 0.5) {
            eat();
        } else {
            breed();
        }
    }
}
