package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals.CarnivoreAnimal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals.HerbivoreAnimal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SoulOfAnimals implements Runnable {
    Animal animal;


    public SoulOfAnimals(Animal soul) {
        animal = soul;
    }

    @Override
    public void run() {
        do {
            act();
        } while (animal.getCurrentEnergy().get() != 0);
    }

    public void act() {
        if (animal.getCurrentHanger() < animal.getMaxHunger() * 0.5) {
            animal.eat();
        } else {
            animal.breed();
        }
    }
}
