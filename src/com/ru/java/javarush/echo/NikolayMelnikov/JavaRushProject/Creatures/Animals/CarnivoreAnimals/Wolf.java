package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(30)
public class Wolf extends CarnivoreAnimal {

    public Wolf(int x, int y) {
        super(x, y);
    }

    public Wolf(Coordinates position) {
        super(position);
    }

    {
        name = "Волк";
        weight = 50;
        energy = 3;
        hanger = 8;
    }
}
