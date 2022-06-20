package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

import java.util.concurrent.atomic.AtomicInteger;

@MaxCapacity(50)
@LuckNumber(11)
public class Boar extends HerbivoreAnimal {

    {
        setName("Кабан");
    }


    public Boar(int x, int y) {
        super(x, y);
        init();
    }

    public Boar(Coordinates position) {
        super(position);
        init();
    }
}
