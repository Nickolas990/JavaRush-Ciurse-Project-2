package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Main;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Interfaces.Printer;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.Executors.ActingOfTheWorld;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.Executors.FaunaImmigrator;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.GrassSeeder;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.StatisticsPrinter;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Starter {
    private int day = 0;
    private Printer printer = new StatisticsPrinter();
    ExecutorService service = Executors.newSingleThreadExecutor();
    ScheduledExecutorService grassService = Executors.newScheduledThreadPool(3);

    public void startSimulation() {
        grassService.scheduleAtFixedRate(new GrassSeeder(), 0, 5, TimeUnit.MINUTES);
        Scanner scanner = new Scanner(System.in);
        FaunaImmigrator.immigration();
        System.out.println("Животные и растения на своих местах. Начать симуляцию? Y/N");
        String answer = scanner.nextLine();
        if ("Y".equals(answer)) {
            while (true) {
                service.submit(new ActingOfTheWorld());
                System.out.println(String.format("День %d окончен, состояние острова:" , ++day));
                printer.print();
                System.out.println("Начать новый день?");
                answer = scanner.nextLine();
                if ("no".equalsIgnoreCase(answer)) {
                    break;
                }
                startNewDay();
            }
        }
        grassService.shutdown();
    }

    public void startNewDay() {

        System.out.println("Начинаем новый день...");
        for (int i = 0; i < Island.instance.getXSize(); i++) {
            for (int j = 0; j < Island.instance.getYSize(); j++) {
                Island.instance.getCell(i, j).getFauna().stream().forEach(Creature::restoreEnergy);
            }
        }
    }
}
