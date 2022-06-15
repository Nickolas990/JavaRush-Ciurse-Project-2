package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacity(30)
@LuckNumber(2)
public class Fox extends CarnivoreAnimal {
    public Fox(int x, int y) {
        super(x, y);
    }

    public Fox(Coordinates position) {
        super(position);
    }

    {
        name = "Лиса";
        weight = 8;
        maxHunger = 2;
        maxEnergy = 2;
        currentEnergy = new AtomicInteger(maxEnergy);
        currentHanger = maxHunger;
    }
}
