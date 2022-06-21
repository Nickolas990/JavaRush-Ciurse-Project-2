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
    ScheduledExecutorService grass = Executors.newScheduledThreadPool(3, new GrassThreadFactory());

    public void startSimulation() {
        new FaunaImmigrator().immigration();
        grass.scheduleAtFixedRate(new GrassSeeder(), 0, 1, TimeUnit.MINUTES);
        while (true) {
            new WorldActingProcessor().process();
            if (new Scanner(System.in).nextLine().equals("exit")) {
                break;
            } else {
                NewDayStarter.startNewDay();
            }
        }
        grass.shutdown();
    }
}
