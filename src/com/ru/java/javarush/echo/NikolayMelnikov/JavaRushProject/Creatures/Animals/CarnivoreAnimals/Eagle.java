package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(20)
public class Eagle extends CarnivoreAnimal {

    {
        setName("Орел");
    }

    public Eagle(int x, int y) {
        super(x, y);
        init();
    }

    public Eagle(Coordinates position) {
        super(position);
        init();
    }
}
