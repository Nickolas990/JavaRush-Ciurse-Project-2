package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacity(140)
@LuckNumber(9)
public class Goat extends HerbivoreAnimal {
    {
        setName("Коза");
    }

    public Goat(int x, int y) {
        super(x, y);
        init();
    }

    public Goat(Coordinates position) {
        super(position);
        init();
    }
}
