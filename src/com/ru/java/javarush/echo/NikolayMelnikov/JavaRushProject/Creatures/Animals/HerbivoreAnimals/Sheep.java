package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(140)
public class Sheep extends HerbivoreAnimal {

    {
        setName("Овца");
    }

    public Sheep(int x, int y) {
        super(x, y);
        init();
    }

    public Sheep(Coordinates position) {
        super(position);
        init();
    }
}
