package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(30)
@LuckNumber(1)
public class Boa extends CarnivoreAnimal{

    public Boa(int x, int y) {
        super(x, y);
    }

    public Boa(Coordinates position) {
        super(position);
    }
    {
        name = "Удав";
        weight = 15;
        maxEnergy = 1;
        currentEnergy = maxEnergy;
        maxHunger = 3;
        currentHanger = maxEnergy;
    }
}
