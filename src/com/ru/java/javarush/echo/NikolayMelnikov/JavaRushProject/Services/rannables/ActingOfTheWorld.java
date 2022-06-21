package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.rannables;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.rannables.DayInCellProcessor;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.StatisticsPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/***
 * При помощи ExecutorService в данном классе производится обработка каждой клетки в отдельном потоке.
 * Ввиду очень медленного метода eat() принято решение распараллелить процесс выполнения дня
 */
public class ActingOfTheWorld implements Runnable {
    public Island island = Island.getInstance();
    public StatisticsPrinter printer = new StatisticsPrinter();

    public ExecutorService service = Executors.newWorkStealingPool(5);

    public void run() {
        System.out.println("Животные начинают движение...");
        for (int x = 0; x < island.getXSize(); x++) {
            for (int y = 0; y < island.getYSize(); y++) {
                Cell cell = Island.getInstance().getCell(x, y);
                if (!cell.getFauna().isEmpty()) {
                    service.submit(new DayInCellProcessor(cell));
                }
            }
        }
        service.shutdown();
        try {
            service.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException("Прерван процесс выполнения дня");
        }
        System.out.println("Завершение дня...");
        printer.print();
    }
}
