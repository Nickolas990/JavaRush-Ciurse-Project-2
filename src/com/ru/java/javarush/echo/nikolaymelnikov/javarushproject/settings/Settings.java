package com.ru.java.javarush.echo.nikolaymelnikov.javarushproject.settings;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Getter
@Setter
@ToString
public class Settings {
    public int wight;
    public int height;

    private int starve;
    private int plantsWeight;
    private int plantsCapacityPerCell;
    private int plantsNutritionalValue;
    private String plantEmoji;

    private AnimalCharacteristics[] animalCharacteristics;



    public static Settings initialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        Settings settings;
        try {
            settings = objectMapper.readValue(Files.newBufferedReader(Path.of("settings.json")), Settings.class);
        } catch (IOException e) {
            throw new RuntimeException(e + " There was a problem with the settings.json file. Check that it is in the settings root directory and matches the Settings() class");
        }
        return settings;
    }
}