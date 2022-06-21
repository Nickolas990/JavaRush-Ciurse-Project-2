package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(200)
public class Duck extends HerbivoreAnimal {
    {
        setName("Утка");
    }

    public Duck(int x, int y) {
        super(x, y);
        init();
    }

    public Duck(Coordinates position) {
        super(position);
        init();
    }
}
