package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@MaxCapacity(5)
@LuckNumber(3)
public class Bear extends CarnivoreAnimal {

    public Bear(int x, int y) {
        super(x, y);
    }

    public Bear(Coordinates position) {
        super(position);
    }
    {
        name = "Медведь";
        weight = 500;
        maxEnergy = 2;
        currentEnergy = new AtomicInteger(maxEnergy);
        maxHunger = 80;
        currentHanger = maxHunger;
    }
}
