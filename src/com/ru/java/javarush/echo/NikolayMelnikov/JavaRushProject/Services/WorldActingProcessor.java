package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services;

public class WorldActingProcessor {
    public void process() {
        new Thread(new ActingOfTheWorld()).start();
    }
}
