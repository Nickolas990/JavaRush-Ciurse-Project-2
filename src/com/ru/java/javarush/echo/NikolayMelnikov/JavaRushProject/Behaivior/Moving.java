package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior;

public interface Moving {
    default void move() {
        System.out.println("Выбрано направление движения");
    }
}
