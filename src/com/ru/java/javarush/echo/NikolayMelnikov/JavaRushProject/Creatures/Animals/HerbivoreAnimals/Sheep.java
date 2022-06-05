package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

public class Sheep extends HerbivoreAnimal {

    public Sheep(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 70;
        this.maxCapacityInCell = 140;
        this.energy = 3;
        this.hanger = 15;
    }
}
