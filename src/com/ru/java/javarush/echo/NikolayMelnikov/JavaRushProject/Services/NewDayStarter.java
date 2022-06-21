package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewDayStarter {
    static ExecutorService service = Executors.newWorkStealingPool();

    public static void startNewDay() {
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
        System.out.println("Животные готовы к новому дню");

    }
}

