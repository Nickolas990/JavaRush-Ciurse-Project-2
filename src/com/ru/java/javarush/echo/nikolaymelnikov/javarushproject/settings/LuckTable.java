package com.ru.java.javarush.echo.nikolaymelnikov.javarushproject.settings;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


public class LuckTable {
    private static Map<String, Map<String, Double>> luckTable;

    static {
        try {
            luckTable = new Gson().fromJson(Files.newBufferedReader(Path.of("luck.json")), HashMap.class);
        } catch (IOException e) {
            throw new RuntimeException(e + " " + "File luck.json is incorrect or not found");
        }
    }

    public static Map<String, Map<String, Double>> getLuckTable() {
        return luckTable;
    }
}


