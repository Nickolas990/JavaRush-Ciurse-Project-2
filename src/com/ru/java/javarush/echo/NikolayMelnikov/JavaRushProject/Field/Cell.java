package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Field;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;

import java.util.HashMap;
import java.util.Map;

public class Cell {

    private Coordinates coordinates = new Coordinates();
    protected Map<Creature, Integer> animalsInCell = new HashMap<>();
    protected Map<Creature, Integer> maxCapacityOfCell;


    public Cell(int x, int y) {
        coordinates.setX(x);
        coordinates.setY(y);
    }

    public void addCreatureInCell (Creature creature) {
        if (animalsInCell.containsKey(creature)) {
            animalsInCell.put(creature, 1);
        } else {
            Integer value = animalsInCell.get(creature);
            animalsInCell.put(creature, value++);
        }
    }

    public String toString() {
        return "Cell(coordinates=" + this.coordinates + ", animalsInCell=" + this.animalsInCell + ", maxCapacityOfCell=" + this.maxCapacityOfCell + ")";
    }


    public class CellInfo {

    }
}
