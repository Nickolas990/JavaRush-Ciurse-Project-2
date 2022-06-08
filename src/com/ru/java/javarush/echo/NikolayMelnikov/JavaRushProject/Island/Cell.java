package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals.CarnivoreAnimal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals.Caterpillar;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals.HerbivoreAnimal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import lombok.Getter;
import lombok.ToString;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@ToString
@Getter
public class Cell {

    @ToString.Exclude
    private final File JSON_SOURCE = new File("src/com/ru/java/javarush/echo/NikolayMelnikov/JavaRushProject/Island/capacityofCell.json");

    private Coordinates coordinates = new Coordinates();
    protected Map<String, Long> animalsInCell = new ConcurrentHashMap<>();
    protected Map<String, Integer> currentCapacityOfCell = new ConcurrentHashMap<>();



    protected List<Creature> fauna = new CopyOnWriteArrayList<>();


    public Cell(int x, int y) {
        coordinates.setX(x);
        coordinates.setY(y);
    }

    public synchronized void addCreatureInCell(Creature creature) {
        fauna.add(creature);
        animalsInCell.merge(creature.getName(), 1L, Long::sum);
        currentCapacityOfCell.putIfAbsent(creature.getName(), creature.getClass().getAnnotation(MaxCapacity.class).value());
        currentCapacityOfCell.merge(creature.getName(), 1, (oldVal, newVal) -> oldVal - newVal);
        if (currentCapacityOfCell.get(creature.getName()) <=0 ){
            System.err.println(String.format("%s погиб, нет места"));
            creature.die();
        }
    }

    private synchronized void capacityOfCellInit(Creature creature) {
        currentCapacityOfCell.compute(creature.getName(), (k, v) -> currentCapacityOfCell.get(k) - 1);
    }

    public Integer getHerbivoreAnimalsQty() {
        return fauna.stream()
                .filter(e -> e instanceof HerbivoreAnimal && !(e instanceof Caterpillar))
                .collect(Collectors.toList())
                .size();
    }
    public Integer getCarnivoreAnimalsQty() {
        return fauna.stream()
                .filter(e -> e instanceof CarnivoreAnimal)
                .collect(Collectors.toList())
                .size();
    }
}
