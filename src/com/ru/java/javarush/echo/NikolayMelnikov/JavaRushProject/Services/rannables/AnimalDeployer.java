package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.rannables;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.CoordinatesCreator;

import java.util.concurrent.ThreadLocalRandom;

public class AnimalDeployer implements Runnable {

    Class creatureClass;
    Island island = Island.getInstance();

    public AnimalDeployer(Class<?> clazz) {
        this.creatureClass = clazz;
    }

    @Override
    public void run()  {

        try {
            MaxCapacity capacityAnnotation = (MaxCapacity) creatureClass.getAnnotation(MaxCapacity.class);
            int quantity = ThreadLocalRandom.current().nextInt(0, capacityAnnotation.value() * island.getXSize() * island.getYSize());
            for (int i = 0; i <= quantity; i++) {
                Animal animal = (Animal) creatureClass.getConstructor(Coordinates.class)
                        .newInstance(CoordinatesCreator.generateCoordinates());
                animal.getThisPosition(animal.getPosition());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
