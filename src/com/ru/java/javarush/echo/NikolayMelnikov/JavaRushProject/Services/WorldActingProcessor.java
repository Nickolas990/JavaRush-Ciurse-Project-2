package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.rannables.ActingOfTheWorld;

public class WorldActingProcessor {
    public void process() {
        new Thread(new ActingOfTheWorld()).start();
    }
}
