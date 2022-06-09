package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(20)
@LuckNumber(6)
public class Deer extends HerbivoreAnimal {

    public Deer(int x, int y) {
        super(x, y);
    }

    public Deer(Coordinates position) {
        super(position);
    }

    {
        name = "Олень";
        weight = 300;
        energy = 4;
        hanger = 50;
    }
}
