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

public class Starter {
    private int day = 0;
    private Printer printer = new StatisticsPrinter();

    public void startSimulation() {
        Scanner scanner = new Scanner(System.in);
        FaunaImmigrator.immigration();

        Thread grass = new Thread(new GrassSeeder());
        grass.start();
        try {
            grass.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Животные и растения на своих местах. Начать симуляцию? Y/N");
        String answer = scanner.nextLine();
        if ("Y".equals(answer)) {
            while (true) {
                ExecutorService service = Executors.newCachedThreadPool();
                service.submit(new ActingOfTheWorld());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(String.format("%d окончен, состояние острова:" , ++day));
                printer.print();
                System.out.println("Начать новый день?");
                answer = scanner.nextLine();
                if ("no".equalsIgnoreCase(answer)) {
                    break;
                }
                startNewDay();
            }
        } else {
            return;
        }
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
