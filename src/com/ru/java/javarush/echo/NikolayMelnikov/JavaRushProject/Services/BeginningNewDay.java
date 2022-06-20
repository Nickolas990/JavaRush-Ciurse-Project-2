package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;

public class BeginningNewDay implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < Island.getInstance().getXSize(); i++) {
            for (int j = 0; j < Island.getInstance().getYSize(); j++) {
                Cell cell = Island.getInstance().getCell(i, j);
                cell.getFauna().stream().forEach(e -> {
                    e.getCurrentEnergy().set(e.getMaxEnergy());
                    e.setCurrentHanger(e.getCurrentHanger() - e.getMaxEnergy());
                    if (e.getCurrentHanger() < 0) {
                        e.setCurrentHanger(0);
                        e.setStarve(e.getStarve() - 1);
                    }
                });


            }
        }



    }
}
