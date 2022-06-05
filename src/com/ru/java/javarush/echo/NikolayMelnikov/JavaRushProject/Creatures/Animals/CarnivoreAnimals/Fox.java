package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;

public class Fox extends CarnivoreAnimal {
    public Fox(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 8;
        this.maxCapacityInCell = 30;
        this.energy = 2;
        this.hanger = 2;
    }
}
