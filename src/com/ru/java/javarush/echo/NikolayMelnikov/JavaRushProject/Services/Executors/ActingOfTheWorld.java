package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.Executors;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.SoulOfAnimals;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ActingOfTheWorld implements Runnable{

    ExecutorService service = Executors.newSingleThreadExecutor();

    public void run() {
        for (int i = 0; i < Island.instance.getXSize(); i++) {
            for (int j = 0; j < Island.instance.getYSize(); j++) {
                Cell cell = Island.instance.getCell(i, j);
                if (!cell.getFauna().isEmpty()) {
                    cell.getFauna().stream().forEach(e -> System.out.println(service.submit(new SoulOfAnimals(e))));
                }
            }
        }
    }
}
