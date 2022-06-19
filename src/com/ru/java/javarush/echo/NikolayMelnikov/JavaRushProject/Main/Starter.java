package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Main;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.ActingOfTheWorld;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.Executors.FaunaImmigrator;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.GrassSeeder;

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
    ScheduledExecutorService grassService = Executors.newScheduledThreadPool(3);



    public void run() {
        grassService.scheduleAtFixedRate(new GrassSeeder(), 0, 1, TimeUnit.MINUTES);
        Scanner scanner = new Scanner(System.in);
        new FaunaImmigrator().immigration();
        System.out.println("Животные и растения на своих местах. Начать симуляцию? Y/N");
        String answer = scanner.nextLine();
        if ("Y".equals(answer)) {
            while (true) {
                Thread actionThread = new Thread(new ActingOfTheWorld());
                actionThread.start();
                try {
                    actionThread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
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
        if (printer.herbivoresQuantity == 0 || printer.carnivoresQuantity == 0) {
            apocalypse();
        }
    }

    public synchronized void startNewDay() {
        System.out.println("Начинаем новый день...");
                cachedService.submit(() -> Arrays.stream(Island.instance.getIsland())
                        .forEach(cell-> Arrays
                                .stream(cell)
                                .forEach(animal -> animal.getFauna()
                                        .forEach(Creature::restoreEnergy))));
    }
    private void apocalypse() {
        //Arrays.stream(Island.instance.getIsland()).forEach(e-> Arrays.stream(e).forEach(Cell::killAll));

        grassService.shutdown();
        grassService.shutdownNow();
        cachedService.shutdown();
        cachedService.shutdownNow();
        service.shutdownNow();
    }
}
