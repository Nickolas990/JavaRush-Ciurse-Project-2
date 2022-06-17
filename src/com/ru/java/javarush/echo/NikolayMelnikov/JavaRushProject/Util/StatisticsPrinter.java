package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Interfaces.Printer;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
@Setter
public class StatisticsPrinter implements Printer {
    public Map<String, Long> quantityOfAnimals = new ConcurrentHashMap<>();
    public Map<String, Long> quantityOfPlants = new ConcurrentHashMap<>();
    public Integer carnivoresQuantity = 0;
    public Integer herbivoresQuantity = 0;
    ExecutorService service = Executors.newCachedThreadPool();

    @Override
    public void print() {
        quantityOfPlants.clear();
        quantityOfAnimals.clear();
        carnivoresQuantity = 0;
        herbivoresQuantity = 0;
        for (int i = 0; i < Island.instance.getXSize(); i++) {
            for (int j = 0; j < Island.instance.getYSize(); j++) {
                Cell cell = Island.instance.getCell(i, j);
                service.submit(() -> {
                        cell.getCreaturesInCell().entrySet().stream().forEach(e -> quantityOfAnimals.merge(e.getKey(), e.getValue(), (o, n) -> o + n));
                        cell.getQtyOfGrass().entrySet().stream().forEach(e -> quantityOfPlants.merge(e.getKey(), e.getValue(), (o, n) -> o + n));
                        carnivoresQuantity += cell.getCarnivoreAnimalsQty();
                        herbivoresQuantity += cell.getHerbivoreAnimalsQty();
                });
            }
        }
        quantityOfAnimals.entrySet().stream().forEach(System.out::println);
        System.out.println();
        quantityOfPlants.entrySet().stream().forEach(System.out::println);
    }
}
