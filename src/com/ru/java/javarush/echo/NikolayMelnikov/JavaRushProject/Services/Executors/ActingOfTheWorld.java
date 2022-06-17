package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.Executors;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.SoulOfAnimals;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.Settings;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ActingOfTheWorld implements Runnable {


    public void run() {
        System.out.println("Животные начинают движение...");
        for (int x = 0; x < Island.instance.getXSize(); x++) {
            for (int y = 0; y < Island.instance.getYSize(); y++) {
                Cell cell = Island.instance.getCell(x, y);
                if (!cell.getFauna().isEmpty()) {
                    cell.getFauna().stream()
                            .filter(e -> e.getCurrentEnergy().get() > 0)
                            .forEach(e -> {
                                while (e.getCurrentEnergy().get() > 0) {
                                    e.act();
                                }
                            });
                }
            }
        }
    }
}
