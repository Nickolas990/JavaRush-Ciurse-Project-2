package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;



public class Boa extends CarnivoreAnimal{

    public Boa(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 15;
        this.maxCapacityInCell = 30;
        this.energy = 1;
        this.hanger = 3;
    }
}
