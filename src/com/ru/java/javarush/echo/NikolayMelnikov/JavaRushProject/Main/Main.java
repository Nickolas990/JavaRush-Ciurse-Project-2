package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Main;


import java.util.concurrent.Phaser;

public class Main {
    private static Starter starter = new Starter();

    public static void main(String[] args) {


        Thread newThread = new Thread(new Starter());
        newThread.start();


    }
}
