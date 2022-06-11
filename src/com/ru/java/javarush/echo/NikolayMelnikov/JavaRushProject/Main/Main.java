package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Main;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Simulation.ActingOfTheWorld;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Simulation.FaunaImmigrator;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Simulation.GrassSeeder;


import java.io.IOException;

import java.util.Scanner;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;


public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        FaunaImmigrator.immigration();
        Thread grass = new Thread(new GrassSeeder());
        grass.start();
        try {
            grass.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Животные и растения на своих местах. Начать симуляцию?");
        scanner.nextLine();

        Thread act = new Thread(new ActingOfTheWorld());
        act.start();
        try {
            act.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
