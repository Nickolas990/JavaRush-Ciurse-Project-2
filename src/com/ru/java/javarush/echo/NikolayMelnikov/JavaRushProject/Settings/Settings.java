package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Settings;

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
 private int plantsNutritionalValue;

 private AnimalCharacteristics[] animalCharacteristics;



 public static Settings initialize() {
     ObjectMapper objectMapper = new ObjectMapper();
     Settings settings;
     try {
         settings = objectMapper.readValue(Files.newBufferedReader(Path.of("src/com/ru/java/javarush/echo/NikolayMelnikov/JavaRushProject/Settings/settings.json")), Settings.class);
     } catch (IOException e) {
         throw new RuntimeException("Возникла проблема с файлом settings.json. Проверьте, что он находится в каталоге settings и соответствует классу Settings()");
     }
     return settings;
 }
}
