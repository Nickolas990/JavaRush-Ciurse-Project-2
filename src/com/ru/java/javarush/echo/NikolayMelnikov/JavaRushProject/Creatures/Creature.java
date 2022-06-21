package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Interfaces.Mortal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@ToString
public abstract class Creature implements Mortal {
    private Coordinates position;
    protected boolean isAlive = true;
    protected String name;
    protected double weight;
    protected int maxEnergy;
    protected AtomicInteger currentEnergy = new AtomicInteger(0);
    protected double maxHunger;
    protected double currentHanger;
    protected int starve;
    protected Map<String, Double> luck;
    protected Cell cell;


    protected static int maxCapacityInCell;

    protected Creature (int x, int y) {
        position.setX(x);
        position.setY(y);
        cell = Island.getInstance().getCell(x, y);

    }

    public Creature(Coordinates position) {
        this.position = position;
        cell = Island.getInstance().getCell(position);

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
        isAlive = false;
        leaveCell();
    }

    public abstract void leaveCell();

    @Override
    public String toString() {
        return "{" + name +
                '}';
    }
    public int reduceEnergy() {
        return currentEnergy.decrementAndGet();
    }



    public void restoreEnergy() {
        currentEnergy.set(maxEnergy);
        currentHanger -= maxEnergy;
        if (currentHanger < 0) {
            currentHanger = 0;
            starve--;
            if (starve < 0) {
                die();
            }
        }
    }
}
