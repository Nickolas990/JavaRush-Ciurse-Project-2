package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;

import java.util.concurrent.ThreadLocalRandom;

public class CoordinatesCreator {
    public static Coordinates generateCoordinates() {
        int generatedX = ThreadLocalRandom.current().nextInt(0, Island.instance.getXSize());
        int generatedY = ThreadLocalRandom.current().nextInt(0, Island.instance.getYSize());
        return new Coordinates(generatedX, generatedY);
    }
}
