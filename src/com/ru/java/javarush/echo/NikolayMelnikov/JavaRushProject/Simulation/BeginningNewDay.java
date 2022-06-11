package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Simulation;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;

public class BeginningNewDay implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < Island.instance.getXSize(); i++) {
            for (int j = 0; j < Island.instance.getYSize(); j++) {
                Cell cell = Island.instance.getCell(i, j);
                cell.getFauna().stream().forEach(e -> {
                    e.setCurrentEnergy(e.getMaxEnergy());
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
