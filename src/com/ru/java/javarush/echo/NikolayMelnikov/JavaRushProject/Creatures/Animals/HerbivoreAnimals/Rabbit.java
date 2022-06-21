package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(150)
public class Rabbit extends HerbivoreAnimal {
    {
        setName("Кролик");
    }

    public Rabbit(int x, int y) {
        super(x, y);
        init();
    }

    public Rabbit(Coordinates position) {
        super(position);
        init();
    }
}
