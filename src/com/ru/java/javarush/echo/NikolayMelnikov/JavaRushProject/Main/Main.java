package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Main;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals.Bear;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals.Horse;

public class Main {
    private static Starter starter = new Starter();

    public static void main(String[] args) {

       Thread newThread = new Thread(new Starter());
       newThread.start();
    }
}
