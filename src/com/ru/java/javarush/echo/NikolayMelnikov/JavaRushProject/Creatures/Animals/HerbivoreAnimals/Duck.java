package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(200)
@LuckNumber(13)
public class Duck extends HerbivoreAnimal {

    public Duck(int x, int y) {
        super(x, y);
    }

    public Duck(Coordinates position) {
        super(position);
    }

    {
        name = "Утка";
        weight = 1;
        maxHunger = 0.15;
        maxEnergy = 4;
        currentEnergy = maxEnergy;
        currentHanger = maxHunger;
    }
}
