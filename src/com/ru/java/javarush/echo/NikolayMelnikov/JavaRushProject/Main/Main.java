package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Main;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals.Horse;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Grass.Plant;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Simulation.ActingOfTheWorld;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Simulation.FaunaImmigrator;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Simulation.GrassSeeder;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Simulation.SoulOfAnimals;


import java.io.IOException;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;


public class Main {
    public static void main(String[] args) throws IOException {

//        Scanner scanner = new Scanner(System.in);
//        FaunaImmigrator.immigration();
//        Thread grass = new Thread(new GrassSeeder());
//        grass.start();
//        try {
//            grass.join();
//        } catch (InterruptedException e) {
//            System.out.println("Interrupted");
//        }
//        System.out.println("Животные и растения на своих местах. Начать симуляцию?");
//        scanner.nextLine();
//
//        ExecutorService service = Executors.newCachedThreadPool();
//        service.submit(new ActingOfTheWorld());
//
//        Thread act = new Thread(new ActingOfTheWorld());
//        act.start();
//        try {
//            act.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Cell cell = Island.instance.getCell(20, 19);

        Horse horse1 = new Horse(20, 18);
        Horse horse2 = new Horse(20,19);

        Island.instance.addAnimal(horse1);
        Island.instance.addAnimal(horse2);

        System.out.println(Island.instance.getCell(horse2.getPosition()).getHerbivoreAnimalsQty());

        new SoulOfAnimals(horse1).run();
        System.out.println(Island.instance.getCell(20, 19));


    }
}
