package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;


@MaxCapacity(500)
public class Mouse extends HerbivoreAnimal {


    public Mouse(int x, int y) {
        super(x, y);
    }

    public Mouse(Coordinates position) {
        super(position);
    }

    {
        name = "РњС‹С€СЊ";
        weight = 0.05;
        energy = 1;
        hanger = 0.01;
    }
}
