package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacity(1000)
@LuckNumber(14)
public class Caterpillar extends HerbivoreAnimal {


    public Caterpillar(int x, int y) {
        super(x, y);
    }

    public Caterpillar(Coordinates position) {
        super(position);
    }

    {
        name = "Гусеница";
        weight = 0.01;
        maxEnergy = 0;
        maxHunger = 0;
        currentEnergy = new AtomicInteger(maxEnergy);
        currentHanger = maxHunger;
    }
}
