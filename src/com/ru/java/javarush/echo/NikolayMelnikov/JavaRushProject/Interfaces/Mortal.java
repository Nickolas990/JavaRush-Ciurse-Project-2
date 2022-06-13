package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Interfaces;

public interface Mortal {
    default void die() {
        //System.out.println(this + " Погиб");
    }
}
