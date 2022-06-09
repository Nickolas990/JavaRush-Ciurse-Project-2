package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Breeding;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Eating;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Moving;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
public abstract class Animal extends Creature implements Moving, Eating, Breeding {


    protected List<Cell> accessibleCells = new ArrayList<>();
    {
        Coordinates coordinates = this.getPosition();
        if (coordinates.getX() - 1 >= 0) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX() - 1, coordinates.getY()));
        }
        if (coordinates.getY() - 1 >= 0) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX(), coordinates.getY() - 1));
        }
        if (coordinates.getX() + 1 <= Island.instance.getXSize()) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX() + 1, coordinates.getY()));
        }
        if (coordinates.getY() + 1 <= 0) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX(), coordinates.getY() + 1));
        }
    }


    public Animal(Coordinates position) {
        super(position);
    }
    public Animal (int x, int y) {
        super(new Coordinates(x, y));
    }

    @Override
    public void moveTo(Cell newCell) {
        this.leaveCell();
        System.out.println(this + " перешел в клетку " + newCell.getCoordinates());
        newCell.addCreatureInCell(this);
    }

    @Override
    public Animal chooseForBreed() {
        Class clazz = this.getClass();
        Cell cell = Island.instance.getCell(this.getPosition());
        return (Animal) cell.getFauna().stream().filter(e -> e.getName().equals(this.getName())).findAny().orElseGet(null);
    }

    @Override
    public void breed(Animal animal) {
        animal.energy--;
        this.energy--;
        try {
            Island.instance.addCreature(this.getClass().getConstructor(Coordinates.class).newInstance(this.getPosition()));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
