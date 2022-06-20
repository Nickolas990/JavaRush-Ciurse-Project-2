package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Grass.Plant;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class GrassSeeder implements Runnable {
    private final String START_MESSAGE = "Сеем траву...";

    @Override
    public void run() {
        System.out.println(LocalTime.now() + " " + START_MESSAGE);
        for (int x = 0; x < Island.getInstance().getXSize(); x++) {
            for (int y = 0; y < Island.getInstance().getYSize(); y++) {
                Cell cell = Island.getInstance().getCell(x, y);
                if (cell.getFlora().size() < 200) {
                    int targetQuantityOfGrass = ThreadLocalRandom.current().nextInt(0, 201);
                    if (cell.getFlora().size() < targetQuantityOfGrass) {
                        for (int k = 0; k < targetQuantityOfGrass; k++) {
                            cell.addPlantInCell(new Plant(cell.getCoordinates()));
                        }
                    }
                }
            }
        }
    }
}
