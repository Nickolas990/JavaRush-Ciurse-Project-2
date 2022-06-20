package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Main;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.ActingOfTheWorld;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.Executors.FaunaImmigrator;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.GrassSeeder;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.GrassThreadFactory;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.StatisticsPrinter;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Starter implements Runnable {
    private int day = 0;
    private StatisticsPrinter printer = new StatisticsPrinter();
    ExecutorService service = Executors.newSingleThreadExecutor();
    ExecutorService cachedService = Executors.newCachedThreadPool();
    ScheduledExecutorService grassService = Executors.newScheduledThreadPool(3, new GrassThreadFactory());
    Island island = Island.getInstance();


    public void run() {
        grassService.scheduleAtFixedRate(new GrassSeeder(), 0, 1, TimeUnit.MINUTES);
        Scanner scanner = new Scanner(System.in);

        FaunaImmigrator faunaImmigrator = new FaunaImmigrator();
        faunaImmigrator.immigration();

        System.out.println("Животные и растения на своих местах. Начать симуляцию? Y/N");
        String answer = scanner.nextLine();
        if ("Y".equals(answer)) {
            while (day != 366) {
                Thread actionThread = new Thread(new ActingOfTheWorld());
                actionThread.start();
                try {
                    actionThread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }

                System.out.println(String.format("День %d окончен, состояние острова:" , ++day));
                printer.print();
                System.out.println("Начать новый день?");
                answer = scanner.nextLine();
                if ("Yes".equalsIgnoreCase(answer)) {
                    startNewDay();
                } else {
                    apocalypse();
                    break;
                }
            }
        }
        if (printer.herbivoresQuantity.get() == 0 || printer.carnivoresQuantity.get() == 0) {
            System.out.println("Мы больше не можем продолжать!");
            apocalypse();
        }
    }

    public synchronized void startNewDay() {
        System.out.println("Начинаем новый день...");
                cachedService.submit(() -> Arrays.stream(island.getIsland())
                        .forEach(cell-> Arrays
                                .stream(cell)
                                .forEach(animal -> animal.getFauna()
                                        .forEach(Creature::restoreEnergy))));
    }
    private void apocalypse() {
        //Arrays.stream(Island.instance.getIsland()).forEach(e-> Arrays.stream(e).forEach(Cell::killAll));
        cachedService.shutdown();
        cachedService.shutdownNow();
        service.shutdownNow();
    }
}
