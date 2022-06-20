package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.CoordinatesCreator;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Settings.Settings;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

public class AnimalDeployer implements Runnable {

    Class creatureClass;
    int islandLength = Island.getInstance().getYSize();
    int islandWidth = Island.getInstance().getYSize();

    public AnimalDeployer(Class<?> clazz) {
        this.creatureClass = clazz;
    }

    @Override
    public void run()  {

        try {
            MaxCapacity capacityAnnotation = (MaxCapacity) creatureClass.getAnnotation(MaxCapacity.class);
            int quantity = ThreadLocalRandom.current().nextInt(0, capacityAnnotation.value() * islandLength*islandWidth);
            for (int i = 0; i <= quantity; i++) {
                Island.getInstance().addAnimal((Animal) creatureClass.getConstructor(Coordinates.class)
                        .newInstance(CoordinatesCreator.generateCoordinates()));
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

}
