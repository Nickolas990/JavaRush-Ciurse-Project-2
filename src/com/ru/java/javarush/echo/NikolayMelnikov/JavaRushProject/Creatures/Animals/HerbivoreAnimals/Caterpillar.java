package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(1000)
public class Caterpillar extends HerbivoreAnimal {


    public Caterpillar(int x, int y) {
        super(x, y);
        init();
    }

    public Caterpillar(Coordinates position) {
        super(position);
        init();
    }
}
