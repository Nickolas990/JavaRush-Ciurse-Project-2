package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(140)
@LuckNumber(10)
public class Sheep extends HerbivoreAnimal {

    public Sheep(int x, int y) {
        super(x, y);
    }

    public Sheep(Coordinates position) {
        super(position);
    }

    {
        name = "Овца";
        weight = 70;
        energy = 3;
        hanger = 15;
    }
}
