package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Main;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals.Bear;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Settings.Settings;

import java.io.IOException;

public class Main {
    private static Starter starter = new Starter();

    public static void main(String[] args) throws IOException {


       Thread newThread = new Thread(new Starter());
       newThread.start();
    }
}
