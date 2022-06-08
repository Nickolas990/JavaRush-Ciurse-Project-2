package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Breeding;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Eating;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Moving;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Getter
public abstract class Animal extends Creature implements Moving, Eating, Breeding {
    protected double weight;
    protected int energy;
    protected double hanger;
    protected static int maxCapacityInCell;

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


}
