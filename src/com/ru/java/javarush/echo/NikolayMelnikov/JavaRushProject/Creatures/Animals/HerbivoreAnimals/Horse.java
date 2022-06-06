package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(20)
public class Horse extends HerbivoreAnimal {
    public Horse(int x, int y) {
        super(x, y);
    }

    public Horse(Coordinates position) {
        super(position);
    }

    {
        name = "Лошадь";
        weight = 400;
        energy = 4;
        hanger = 60;
    }
}
