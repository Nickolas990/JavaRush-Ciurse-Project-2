package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(140)
public class Goat extends HerbivoreAnimal {

    public Goat(int x, int y) {
        super(x, y);
    }

    public Goat(Coordinates position) {
        super(position);
    }

    {
        name = "����";
        weight = 60;
        energy = 3;
        hanger = 10;
    }
}