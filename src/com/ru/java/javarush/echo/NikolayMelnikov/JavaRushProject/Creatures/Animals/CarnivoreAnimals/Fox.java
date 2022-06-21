package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(30)
public class Fox extends CarnivoreAnimal {
    {
        setName("Лиса");
    }
    public Fox(int x, int y) {
        super(x, y);
        init();
    }

    public Fox(Coordinates position) {
        super(position);
        init();
    }

}
