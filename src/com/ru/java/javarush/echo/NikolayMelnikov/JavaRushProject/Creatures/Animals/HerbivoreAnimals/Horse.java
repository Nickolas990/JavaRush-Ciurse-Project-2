package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals.HerbivoreAnimal;

public class Horse extends HerbivoreAnimal {


    public Horse(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 400;
        this.maxCapacityInCell = 20;
        this.energy = 4;
        this.hanger = 60;
    }
}
