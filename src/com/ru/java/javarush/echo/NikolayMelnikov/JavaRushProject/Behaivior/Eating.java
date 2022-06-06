package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;

public interface Eating {
    default void eat (Creature creature) {
        System.out.println(String.format(" %s СЃСЉРµРґР°РµС‚ %s", this, creature));
    }
}
