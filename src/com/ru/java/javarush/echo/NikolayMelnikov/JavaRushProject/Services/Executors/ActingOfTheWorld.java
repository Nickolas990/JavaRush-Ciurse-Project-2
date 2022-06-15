package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.Executors;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.SoulOfAnimals;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.Settings;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ActingOfTheWorld implements Runnable{

    ExecutorService service = Executors.newFixedThreadPool(15);

    public void run() {
        System.out.println("Животные начинают движение...");
        for (int i = 0; i < Island.instance.getXSize(); i++) {
            for (int j = 0; j < Island.instance.getYSize(); j++) {
                Cell cell = Island.instance.getCell(i, j);
                if (!cell.getFauna().isEmpty()) {
                    cell.getFauna().stream().filter(e -> e.getCurrentEnergy().get() > 0).forEach(e -> service.submit(new SoulOfAnimals(e)));
                }
            }
        }
        service.shutdown();
    }
}
