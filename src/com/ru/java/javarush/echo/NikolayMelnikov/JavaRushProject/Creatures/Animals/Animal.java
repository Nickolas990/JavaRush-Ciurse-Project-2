package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Interfaces.Breeding;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Interfaces.Eating;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Interfaces.Moving;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.Luck;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
public abstract class Animal extends Creature implements Moving, Eating, Breeding {


    protected int starve = 3;


    public Animal(Coordinates position) {
        super(position);
    }
    public Animal (int x, int y) {
        super(new Coordinates(x, y));
    }

    @Override
    public void moveTo(Cell newCell) {
        this.currentEnergy--;
        this.leaveCell();
        System.out.println(this + " перешел в клетку " + newCell.getCoordinates());
        newCell.addAnimalInCell(this);
        this.setPosition(newCell.getCoordinates());
    }


    @Override
    public void breed(Animal animal) {
        try {
            Island.instance.addAnimal(this.getClass().getConstructor(Coordinates.class).newInstance(this.getPosition()));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        animal.currentEnergy--;
        this.currentEnergy--;
    }

    public Animal chooseVictim() {
        Cell cell = Island.instance.getCell(this.getPosition());
        List<Animal> accessibleAnimals = cell.getFauna().stream()
                .filter(e -> Luck.getLuck(this
                                .getClass()
                                .getAnnotation(LuckNumber.class)
                                .value(),
                        e.getClass()
                                .getAnnotation(LuckNumber.class).value()) > 0)
                .toList();
        return accessibleAnimals.stream().max(Comparator.comparing(Creature::getWeight)).orElseGet(this::chooseVictim);
    }

    public void tryToEat(Animal victim) {
        Integer luck = Luck.getLuck(this.getClass().getAnnotation(LuckNumber.class).value(), victim.getClass().getAnnotation(LuckNumber.class).value());
        if (ThreadLocalRandom.current().nextInt(0, 101) < luck) {
            System.out.println(String.format("%s съел %s", this.getName(), victim.getName()));
            this.currentHanger += victim.getWeight();
            this.setStarve(3);
            if (this.currentHanger > this.maxHunger) {
                this.currentHanger = this.maxHunger;
            }
            victim.die();
        } else {
            System.out.println(String.format("%s не смог съесть %s", this.getName(), victim.getName()));
        }
    }
}
