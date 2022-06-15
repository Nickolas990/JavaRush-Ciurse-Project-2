package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacity(30)
@LuckNumber(0)
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
        maxHunger = 8;
        maxEnergy = 3;
        currentEnergy = new AtomicInteger(maxEnergy);
        currentHanger = maxHunger;
    }
}
