package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Main;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Field.Field;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Field field = Field.instance;
        System.out.println(field.getCell(50, 19));


    }
}
