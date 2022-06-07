package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(200)
public class Duck extends HerbivoreAnimal {

    public Duck(int x, int y) {
        super(x, y);
    }

    public Duck(Coordinates position) {
        super(position);
    }

    {
        name = "Утка";
        weight = 1;
        energy = 4;
        hanger = 0.15;
    }
}
