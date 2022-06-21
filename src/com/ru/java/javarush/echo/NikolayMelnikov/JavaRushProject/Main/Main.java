package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Main;

public class Main {
    private static Starter starter = new Starter();

    public static void main(String[] args) {

//        new Runner().startSimulation();

        String dir = System.getProperty("user.dir");
        System.out.println(dir);

        //       Thread newThread = new Thread(new Starter());
//       newThread.start();
    }
}
