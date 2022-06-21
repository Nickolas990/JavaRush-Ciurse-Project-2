package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Settings;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class LuckTable {
    private static Map<String, Map<String, Double>> luck;

    static {
        try {
            luck = new Gson().fromJson(Files.newBufferedReader(Path.of("src/com/ru/java/javarush/echo/NikolayMelnikov/JavaRushProject/Settings/luck.json")), HashMap.class);
        } catch (IOException e) {
            throw new RuntimeException("Не найден файл настройки удачи. Проверьте правильное местоположение файла luck.json");
        }
    }

    public static Map<String, Map<String, Double>> getLuck() {
        return luck;
    }
}


