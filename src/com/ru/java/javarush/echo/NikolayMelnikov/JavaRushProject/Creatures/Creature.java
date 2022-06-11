package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Mortal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Creature implements Mortal {
    Coordinates position;
    boolean isAlive = true;
    protected String name;
    protected double weight;
    protected int maxEnergy;
    protected int currentEnergy;
    protected double maxHunger;
    protected double currentHanger;
    protected int starve;


    protected static int maxCapacityInCell;

    protected Creature (int x, int y) {
        position.setX(x);
        position.setY(y);

    }

    public Creature(Coordinates position) {
        this.position = position;

    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        position.setX(x);
        position.setY(y);
    }

    public void setPosition(Coordinates coordinates) {
        position.setX(coordinates.getX());
        position.setY(coordinates.getY());
    }


    @Override
    public void die() {
        Mortal.super.die();
        isAlive = false;
        leaveCell();
    }

    public synchronized void leaveCell() {
        Cell cell =  Island.instance.getCell(this.getPosition());
        cell.getFauna().remove(this);
        Integer qtyofAnimals = cell.getCurrentCapacityOfCell().get(this.getName());
        cell.getCurrentCapacityOfCell().put(this.getName(), qtyofAnimals - 1);
    }

    @Override
    public String toString() {
        return "{" + name +
                '}';
    }
}
