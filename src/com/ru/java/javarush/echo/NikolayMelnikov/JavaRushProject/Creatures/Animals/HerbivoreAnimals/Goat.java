package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

public class Goat extends HerbivoreAnimal {

    public Goat(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 60;
        this.maxCapacityInCell = 140;
        this.energy = 3;
        this.hanger = 10;
    }
}
