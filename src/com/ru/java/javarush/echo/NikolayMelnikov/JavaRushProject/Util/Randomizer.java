package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {


    public static int randomize(int lb, int rb) {
        return ThreadLocalRandom.current().nextInt(lb, rb);
    }
}
