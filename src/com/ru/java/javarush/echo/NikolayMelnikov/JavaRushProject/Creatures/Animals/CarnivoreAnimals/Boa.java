package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacity(30)
@LuckNumber(1)
public class Boa extends CarnivoreAnimal{

    {
        setName("Удав");
    }

    public Boa(int x, int y) {
        super(x, y);
        init();
    }

    public Boa(Coordinates position) {
        super(position);
        init();
    }
}
