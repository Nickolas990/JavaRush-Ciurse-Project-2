package com.ru.java.javarush.echo.nikolaymelnikov.javarushproject.services.rannables;

import com.ru.java.javarush.echo.nikolaymelnikov.javarushproject.island.Cell;

public class DayInCellProcessor implements Runnable {
    Cell cell;


    public DayInCellProcessor(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void run() {
        cell.getFauna().stream().forEach(animal -> {
            animal.getLogList().clear();
            Thread.currentThread().setName("Animal" + " " + animal.getPosition());
            do {
                if (animal.getCurrentHanger() < animal.getMaxHunger()/2) {
                    animal.eat();
                } else {
                    animal.breed();
                }
            } while (animal.getCurrentEnergy().get() > 0);
        });
    }
}
