package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Simulation.FaunaImmigrator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;


public class Main {
    public static void main(String[] args) throws IOException {

        FaunaImmigrator.immigration();


    }
}
