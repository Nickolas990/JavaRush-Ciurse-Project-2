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
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Settings.AnimalCharacteristics;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Settings.LuckTable;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Settings.Settings;
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


    protected int starve = Island.getInstance().getSettings().getStarve();
    protected List<Cell> accessibleCells = new ArrayList<>();
    public List<String> logList = new ArrayList<>();
    AnimalCharacteristics[] animalCharacteristics = Settings.initialize().getAnimalCharacteristics();


    public Animal(Coordinates position) {
        super(position);
    }
    public Animal (int x, int y) {
        super(new Coordinates(x, y));
    }

    @Override
    public void moveTo(Cell newCell) {
        reduceEnergy();
        logList.add("Начинает движение в клетку " + newCell.getCoordinates());
        if (getCurrentEnergy().get() < 0) {
            throw new RuntimeException("Нет доступных очков хода");
        }
        leaveCell();
        newCell.addAnimalInCell(this);
        setPosition(newCell.getCoordinates());
        logList.add("Закончил перемещение");
    }


    @Override
    public void breed() {
        logList.add("Начат процесс спаривания");
        List<Animal> breeders = chooseForBreed();
        if (!breeders.isEmpty()) {
            Animal animal = breeders.get(Randomizer.randomize(0, breeders.size()));
            try {
                Island.getInstance().getCell(animal.getPosition()).addAnimalInCell(this.getClass().getConstructor(Coordinates.class).newInstance(this.getPosition()));
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
            animal.reduceEnergy();
            this.reduceEnergy();
        } else {
            initializeAccessibleCells();
            moveTo(choosingDirectionForBreed());
        }
        logList.add("Процесс спаривания завершен");
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
        Cell cell = Island.getInstance().getCell(getPosition());
        return cell.getFauna().stream().filter(e -> e.getName().equals(getName())
                && !(e.equals(this)) && e.getCurrentEnergy().get() > 0 && e.currentHanger > e.maxHunger/2).toList();
    }

    public Animal chooseVictim(List<Animal> accessibleAnimals) {

        return accessibleAnimals.stream()
                .max(Comparator.comparing(Creature::getWeight))
                .orElse(accessibleAnimals.get(Randomizer.randomize(0, accessibleAnimals.size())));
    }

    public void tryToEat(Animal victim) {
        Double luck = getLuck().get(victim.getName());
        if (ThreadLocalRandom.current().nextInt(0, 100) < luck) {
           // System.out.println(String.format("%s съел %s", this.getName(), victim.getName()));
            this.setCurrentHanger(getCurrentHanger() + victim.getWeight());
            this.setStarve(3);
            if (this.getCurrentHanger() > this.getMaxHunger()) {
                this.setCurrentHanger(getMaxHunger());
            }
            victim.die();
        }
    }
    protected void initializeAccessibleCells() {
        accessibleCells.clear();
        Coordinates coordinates = this.getPosition();

        if (coordinates.getX() - 1 >= 0) {
            accessibleCells.add(Island.getInstance().getCell(coordinates.getX() - 1, coordinates.getY()));
        }
        if (coordinates.getY() - 1 >= 0) {
            accessibleCells.add(Island.getInstance().getCell(coordinates.getX(), coordinates.getY() - 1));
        }
        if ((coordinates.getX() + 1) < Island.getInstance().getXSize()) {
            accessibleCells.add(Island.getInstance().getCell(coordinates.getX() + 1, coordinates.getY()));
        }
        if (coordinates.getY() + 1 < Island.getInstance().getYSize()) {
            accessibleCells.add(Island.getInstance().getCell(coordinates.getX(), coordinates.getY() + 1));
        }
    }

    @Override
    public void leaveCell() {
            Cell cell =  Island.getInstance().getCell(this.getPosition());
        cell.getFauna().remove(this);
        cell.getCurrentCapacityOfCell().merge(getName(), 1, Integer::sum);

        if (cell.getCurrentCapacityOfCell().get(getName()) >= getClass().getAnnotation(MaxCapacity.class).value()) {
            cell.getCurrentCapacityOfCell().remove(getName());
        }
        cell.removeThis(this);
    }

    public void act() {
        if (getCurrentHanger() < getMaxHunger() * 0.5) {
            logList.add("Процесс поедания начат");
            eat();
            logList.add("Процесс поедания завершен");
        } else {
            breed();
        }
    }

    public void init() {
        for (AnimalCharacteristics animal : animalCharacteristics ) {
            if (animal.getName().equals(getName())) {
                weight = animal.getWeight();
                maxEnergy = animal.getMaxEnergy();
                maxHunger = animal.getMaxHunger();
                currentEnergy.set(animal.getCurrentEnergy());
                currentHanger = animal.getCurrentHunger();
                luck = LuckTable.getLuck().get(animal.getName());
            }
        }
    }

//    @Override
//    public void eat() {
//
//    }
}
