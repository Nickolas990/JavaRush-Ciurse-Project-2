package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.rannables.ActingOfTheWorld;

public class WorldActingProcessor {
    public void process() {
        Thread thread = new Thread(new ActingOfTheWorld());
        thread.setName("World Act");
        thread.start();
    }
}
