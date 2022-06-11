package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals.CarnivoreAnimal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals.HerbivoreAnimal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Grass.Plant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@ToString
@Getter
@Setter
public class Cell {

    @ToString.Exclude
    private final File JSON_SOURCE = new File("src/com/ru/java/javarush/echo/NikolayMelnikov/JavaRushProject/Island/capacityofCell.json");

    private Coordinates coordinates = new Coordinates();
    protected Map<String, Long> creaturesInCell = new ConcurrentHashMap<>();
    protected Map<String, Integer> currentCapacityOfCell = new ConcurrentHashMap<>();
    protected Map<String, Integer> qtyOfGrass = new ConcurrentHashMap<>();



    protected List<Animal> fauna = new CopyOnWriteArrayList<>();
    protected  List<Plant> flora = new CopyOnWriteArrayList<>();


    public Cell(int x, int y) {
        coordinates.setX(x);
        coordinates.setY(y);
    }

    public synchronized void addAnimalInCell(Animal animal) {
        fauna.add(animal);
        creaturesInCell.merge(animal.getName(), 1L, Long::sum);
        updateCapacity(animal);
        if (currentCapacityOfCell.get(animal.getName()) <=0 ){
            System.err.println(String.format("%s погиб, нет места"));
            animal.die();
        }
    }
    private void updateCapacity(Creature creature) {
        currentCapacityOfCell.putIfAbsent(creature.getName(), creature.getClass().getAnnotation(MaxCapacity.class).value());
        currentCapacityOfCell.merge(creature.getName(), 1, (oldVal, newVal) -> oldVal - newVal);
    }

    public synchronized void addPlantInCell(Plant plant) {
        flora.add(plant);
        creaturesInCell.merge(plant.getName(), 1L, Long::sum);
    }

    private synchronized void capacityOfCellInit(Creature creature) {
        currentCapacityOfCell.compute(creature.getName(), (k, v) -> currentCapacityOfCell.get(k) - 1);
    }

    public Integer getHerbivoreAnimalsQty() {
        return fauna.stream()
                .filter(e -> e instanceof HerbivoreAnimal)
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
