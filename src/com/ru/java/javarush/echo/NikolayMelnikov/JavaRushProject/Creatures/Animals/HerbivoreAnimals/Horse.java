package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacity(20)
@LuckNumber(5)
public class Horse extends HerbivoreAnimal {
    {
        setName("Лошадь");
    }
    public Horse(int x, int y) {
        super(x, y);
        init();
    }

    public Horse(Coordinates position) {
        super(position);
        init();
    }
}
