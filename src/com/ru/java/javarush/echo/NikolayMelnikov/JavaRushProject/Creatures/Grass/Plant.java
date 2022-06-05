package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Grass;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Field.Coordinates;

public class Plant extends Creature {
    int weight;
    int maxCapacityInCell;

    public Plant(Coordinates position) {
        super(position);
    }

    public Plant (int x, int y) {
        super(x, y);
    }

    {
        this.weight = 1;
        this.maxCapacityInCell = 200;
    }
}
