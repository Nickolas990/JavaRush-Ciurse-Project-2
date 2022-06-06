package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MaxCapacity(5)
public class Bear extends CarnivoreAnimal {

    public Bear(int x, int y) {
        super(x, y);
    }

    public Bear(Coordinates position) {
        super(position);
    }

    {
        name = "Ìוהגוהü";
        weight = 500;
        energy = 2;
        hanger = 80;
    }
}
