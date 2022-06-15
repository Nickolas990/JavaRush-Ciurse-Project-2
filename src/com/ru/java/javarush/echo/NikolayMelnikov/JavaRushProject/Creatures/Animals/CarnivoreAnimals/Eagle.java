package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacity(20)
@LuckNumber(4)
public class Eagle extends CarnivoreAnimal {

    public Eagle(int x, int y) {
        super(x, y);
    }

    public Eagle(Coordinates position) {
        super(position);
    }

    {
        name = "Орел";
        weight = 6;
        maxEnergy = 3;
        maxHunger = 1;
        currentEnergy = new AtomicInteger(maxEnergy);
        currentHanger = maxHunger;
    }
}
