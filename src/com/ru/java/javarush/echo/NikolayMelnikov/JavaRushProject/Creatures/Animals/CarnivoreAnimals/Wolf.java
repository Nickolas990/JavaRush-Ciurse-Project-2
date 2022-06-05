package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;

public class Wolf extends CarnivoreAnimal {

    public Wolf(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 50;
        this.maxCapacityInCell = 30;
        this.energy = 3;
        this.hanger = 8;
    }
}
