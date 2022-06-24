package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(20)
public class Deer extends HerbivoreAnimal {

    public Deer(int x, int y) {
        super(x, y);
        init();
    }

    public Deer(Coordinates position) {
        super(position);
        init();
    }
}
