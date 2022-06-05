package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import lombok.Generated;

@Generated
public class Buffalo extends HerbivoreAnimal {


    public Buffalo(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 700;
        this.maxCapacityInCell = 10;
        this.energy = 3;
        this.hanger = 100;
    }

}
