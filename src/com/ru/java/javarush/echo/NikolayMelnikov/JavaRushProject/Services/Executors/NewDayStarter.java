package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.Executors;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewDayStarter {
    static ExecutorService service;


    public static void startNewDay() {
        service = Executors.newFixedThreadPool(10);
        Thread.currentThread().setName("NewDayStarter");
        System.out.println("Начинаем новый день...");
        service.submit(() -> Arrays.stream(Island.getInstance().getIsland())
                .forEach(cell -> Arrays
                        .stream(cell)
                        .forEach(animal -> animal.getFauna()
                                .forEach(Creature::restoreEnergy))));
        try {
            if (service.awaitTermination(3, TimeUnit.SECONDS)) {
                System.out.println("Силы животных восстановлены не полностью");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Превышено ожидание потоков восстановления энергии");
        }

        try {
            service.awaitTermination(5, TimeUnit.SECONDS);
            service.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException("Выполнение дня прервано");
        }
        System.out.println("Животные готовы к новому дню");

    }
}

