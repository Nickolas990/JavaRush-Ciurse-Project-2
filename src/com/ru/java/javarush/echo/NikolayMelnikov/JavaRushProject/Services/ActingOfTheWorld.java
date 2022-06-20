package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;

public class ActingOfTheWorld implements Runnable {
    Island island = Island.getInstance();

    //  ExecutorService service = Executors.newWorkStealingPool(5);
    public void run() {
        System.out.println("Животные начинают движение...");
        for (int x = 0; x < island.getXSize(); x++) {
            for (int y = 0; y < island.getYSize(); y++) {
                Cell cell = island.getCell(x, y);
                if (!cell.getFauna().isEmpty()) {
                    cell.getFauna().stream()
                            .forEach(e -> {
                                while (e.getCurrentEnergy().get() > 0) {
                                    e.act();
                                }
                            });
                }
            }
        }
        System.out.println("День окончен!");
    }
}
