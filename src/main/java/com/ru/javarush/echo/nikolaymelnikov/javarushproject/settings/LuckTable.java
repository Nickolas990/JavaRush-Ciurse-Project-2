package com.ru.javarush.echo.nikolaymelnikov.javarushproject.settings;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;


public class LuckTable {
    private static Map<String, Map<String, Double>> luckTable;

    static {
        try {
            luckTable = new Gson().fromJson(Files.newBufferedReader(getFileFromResource("luck.json")), HashMap.class);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e + " " + "File luck.json is incorrect or not found");
        }
    }

    public static Map<String, Map<String, Double>> getLuckTable() {
        return luckTable;
    }

    private static Path getFileFromResource(String filename) throws URISyntaxException {
        URL resource = LuckTable.class.getClassLoader().getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException("File settings.json not found");
        } else {
            return Path.of(resource.toURI());
        }
    }
}


