package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.Executors.FaunaImmigrator;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.Executors.NewDayStarter;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.rannables.GrassSeeder;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.GrassThreadFactory;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Runner {
    int day = 0;
    Scanner scanner = new Scanner(System.in);
    private ScheduledExecutorService grass = Executors.newScheduledThreadPool(1, new GrassThreadFactory());

    public void startSimulation() {
        new FaunaImmigrator().immigration();
       grass.scheduleAtFixedRate(new GrassSeeder(), 0, 1, TimeUnit.MINUTES);
        while (true) {
            new WorldActingProcessor().process();
            String answer = scanner.nextLine();
            if ("exit".equalsIgnoreCase(answer)) {
                System.out.println("Введено exit");
                break;
            } else {
                NewDayStarter.startNewDay();
            }
        }
        try {
            grass.shutdown();
            grass.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Цикл прерван");

    }
}
