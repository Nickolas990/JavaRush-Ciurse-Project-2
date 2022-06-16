package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals.CarnivoreAnimal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals.HerbivoreAnimal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Grass.Plant;


import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@ToString
@Getter
@Setter
public class Cell {

    @ToString.Exclude
    private Coordinates coordinates = new Coordinates();
    private Map<String, Long> creaturesInCell = new ConcurrentHashMap<>();
    private Map<String, Integer> currentCapacityOfCell = new ConcurrentHashMap<>();
    private Map<String, Long> qtyOfGrass = new ConcurrentHashMap<>();


    private List<Animal> fauna = new CopyOnWriteArrayList<>();
    private  List<Plant> flora = new CopyOnWriteArrayList<>();


    public Cell(int x, int y) {
        coordinates.setX(x);
        coordinates.setY(y);
    }

    public void addAnimalInCell(Animal animal) {
        fauna.add(animal);
        creaturesInCell.merge(animal.getName(), 1L, Long::sum);
        updateCapacity(animal);
        if (currentCapacityOfCell.get(animal.getName()) <=0 ){
           // System.err.println(String.format("%s погиб, нет места"));
            animal.die();
        }
    }
    private void updateCapacity(Creature creature) {
        currentCapacityOfCell.putIfAbsent(creature.getName(), creature.getClass().getAnnotation(MaxCapacity.class).value());
        currentCapacityOfCell.merge(creature.getName(), 1, (oldVal, newVal) -> oldVal - newVal);
    }

    public void addPlantInCell(Plant plant) {
        flora.add(plant);
        qtyOfGrass.merge(plant.getName(), 1L, Long::sum);
       // creaturesInCell.merge(plant.getName(), 1L, Long::sum);
    }

    private synchronized void capacityOfCellInit(Creature creature) {
        currentCapacityOfCell.compute(creature.getName(), (k, v) -> currentCapacityOfCell.get(k) - 1);
    }

    public Integer getHerbivoreAnimalsQty() {
        return fauna.stream()
                .filter(e -> e instanceof HerbivoreAnimal)
                .toList()
                .size();
    }
    public Integer getCarnivoreAnimalsQty() {
        return fauna.stream()
                .filter(e -> e instanceof CarnivoreAnimal)
                .collect(Collectors.toList())
                .size();
    }

    public Integer getPlantsQty() {
        return flora.size();
    }

    public void leavingOfPlant(Creature creature) {
        flora.remove(creature);
        qtyOfGrass.merge(creature.getName(), 1L, (oldVal, newVal) -> oldVal - newVal);
        if (qtyOfGrass.get(creature.getName()) < 0) {
            qtyOfGrass.remove(creature.getName());
        }
        removeThis(creature);
    }

    public void leavingOfAnimal(Creature creature) {
        fauna.remove(creature);
        currentCapacityOfCell.merge(creature.getName(), 1, Integer::sum);

        if (currentCapacityOfCell.get(creature.getName()) >= creature.getClass().getAnnotation(MaxCapacity.class).value()) {
            currentCapacityOfCell.remove(creature.getName());
        }
        removeThis(creature);
    }

    private void removeThis(Creature creature) {
        creaturesInCell.merge(creature.getName(), 1L, (oldVal, newVal) -> oldVal - newVal);
        if (creaturesInCell.get(creature.getName()) < 0 || creaturesInCell.get(creature.getName()) != null ) {
            creaturesInCell.remove(creature.getName());
        }
    }
    public void killAll() {
        fauna.stream().forEach(Creature::die);
        flora.stream().forEach(Creature::die);
    }
}
