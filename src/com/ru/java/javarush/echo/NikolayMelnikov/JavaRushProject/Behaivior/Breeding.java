package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior;



public interface Breeding {
    default void breed() {
        System.out.println(String.format("%s размножился", this));
    }
}
