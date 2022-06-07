package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Grass;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Mortal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

public class Plant extends Creature implements Mortal {
    int weight;
    int maxCapacityInCell;

    public Plant(Coordinates position) {
        super(position);
    }

    public Plant (int x, int y) {
        super(x, y);
    }

    {
        name = "Растение";
        weight = 1;
        maxCapacityInCell = 200;
    }

    @Override
    public void die() {
        super.die();
    }
}
