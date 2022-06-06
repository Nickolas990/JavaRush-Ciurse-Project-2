package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior;

public interface Mortal {
    default void die() {
        System.out.println(this + " РїРѕРіРёР±");
    }
}
