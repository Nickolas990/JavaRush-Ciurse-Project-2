package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(150)
public class Rabbit extends HerbivoreAnimal {

    public Rabbit(int x, int y) {
        super(x, y);
    }

    public Rabbit(Coordinates position) {
        super(position);
    }

    {
        name = "РљСЂРѕР»РёРє";
        weight = 2;
        energy = 2;
        hanger = 0.45;
    }
}
