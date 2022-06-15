package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Main;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals.Horse;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Grass.Plant;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.Executors.ActingOfTheWorld;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.Executors.FaunaImmigrator;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.GrassSeeder;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.SoulOfAnimals;


import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        new Starter().startSimulation();


 //       Cell cell = Island.instance.getCell(20, 19);
      //  cell.addPlantInCell(new Plant(cell.getCoordinates()));
      //  cell.addPlantInCell(new Plant(cell.getCoordinates()));
      //  cell.addPlantInCell(new Plant(cell.getCoordinates()));
      //  cell.addPlantInCell(new Plant(cell.getCoordinates()));
      //  cell.addPlantInCell(new Plant(cell.getCoordinates()));
      //  cell.addPlantInCell(new Plant(cell.getCoordinates()));

//        Horse horse1 = new Horse(20, 18);
// //       Horse horse2 = new Horse(20,19);
////        Horse horse3 = new Horse(19,19);
//
//        Island.instance.addAnimal(horse1);
// //       Island.instance.addAnimal(horse2);
// //       Island.instance.addAnimal(horse3);
//
//        horse1.setCurrentHanger(0);
//
// //       System.out.println(Island.instance.getCell(horse2.getPosition()).getHerbivoreAnimalsQty());
//
//
//
//       // new SoulOfAnimals(horse1).run();
//        new Thread(new SoulOfAnimals(horse1)).start();
//        Thread.sleep(1000);
//  //      new Thread(new SoulOfAnimals(horse2)).start();
//        //new SoulOfAnimals(horse2).run();
//        System.out.println(Island.instance.getCell(20, 18));
//        System.out.println(Island.instance.getCell(20, 19));
//        System.out.println(Island.instance.getCell(19, 19));
//        System.out.println(horse1);

    }
}
