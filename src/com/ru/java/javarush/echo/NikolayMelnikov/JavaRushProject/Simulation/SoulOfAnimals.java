package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Simulation;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals.CarnivoreAnimal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals.HerbivoreAnimal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SoulOfAnimals implements Runnable{
    public Animal animal;


    public SoulOfAnimals (Animal soul) {
        animal = soul;
    }

    protected List<Cell> accessibleCells = new ArrayList<>();
    {
        Coordinates coordinates = animal.getPosition();

        if (coordinates.getX() - 1 >= 0) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX() - 1, coordinates.getY()));
        }
        if (coordinates.getY() - 1 >= 0) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX(), coordinates.getY() - 1));
        }
        if (coordinates.getX() + 1 <= Island.instance.getXSize()) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX() + 1, coordinates.getY()));
        }
        if (coordinates.getY() + 1 <= 0) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX(), coordinates.getY() + 1));
        }
    }


    @Override
    public void run() {
        while (animal.getCurrentEnergy() > 0) {
            if (animal.getCurrentHanger() > animal.getCurrentHanger() / 2) {
                Animal animalToBreed = chooseForBreed();
                if (animalToBreed != null) {
                    animal.breed(animalToBreed);
                } else {
                    animal.moveTo(choosingDirection());
                }
            } else if (animal.getCurrentHanger() < animal.getCurrentHanger()/2) {
                animal.eat();
                }
            }
        }



    public Cell choosingDirection() {
        if(animal instanceof CarnivoreAnimal) { System.out.println(this + " выбирает направление");
        return accessibleCells.stream()
                .max(Comparator.comparing(Cell::getHerbivoreAnimalsQty))
                .orElseGet(() -> Island.instance.getCell(animal.getPosition())); }
        else if (animal instanceof HerbivoreAnimal) {
            return accessibleCells.stream()
                    .min(Comparator.comparing(Cell::getCarnivoreAnimalsQty))
                    .orElseGet(() -> Island.instance.getCell(animal.getPosition()));
        }
        else throw new RuntimeException("Неправильно задан тип животного");
    }

    public Animal chooseForBreed() {
        Class clazz = this.getClass();
        Cell cell = Island.instance.getCell(animal.getPosition());
        return (Animal) cell.getFauna().stream().filter(e -> e.getName().equals(animal.getName())).findAny().orElseGet(null);
    }
}
