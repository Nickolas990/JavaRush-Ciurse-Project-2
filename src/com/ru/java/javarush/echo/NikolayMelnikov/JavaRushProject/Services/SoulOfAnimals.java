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
    Cell cell;


    public SoulOfAnimals(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void run() {
        cell.getFauna().stream().forEach(animal -> {
            animal.getLogList().clear();
            do {
                if (animal.getCurrentHanger() < animal.getMaxHunger() * 0.5) {
                    animal.eat();
                } else {
                    animal.breed();
                }
            } while (animal.getCurrentEnergy().get() > 0);
        });
    }
}
