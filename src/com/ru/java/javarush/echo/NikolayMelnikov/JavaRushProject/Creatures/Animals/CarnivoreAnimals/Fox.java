package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacity(30)
@LuckNumber(2)
public class Fox extends CarnivoreAnimal {
    {
        setName("Лиса");
    }
    public Fox(int x, int y) {
        super(x, y);
        init();
    }

    public Fox(Coordinates position) {
        super(position);
        init();
    }

}
