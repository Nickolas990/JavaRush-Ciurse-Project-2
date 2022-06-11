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
    Animal animal;
    protected List<Cell> accessibleCells = new ArrayList<>();


    public SoulOfAnimals (Animal soul) {
        animal = soul;
    }




    @Override
    public void run() {
        Coordinates coordinates = animal.getPosition();

        if (coordinates.getX() - 1 >= 0) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX() - 1, coordinates.getY()));
        }
        if (coordinates.getY() - 1 >= 0) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX(), coordinates.getY() - 1));
        }
        if ((coordinates.getX() + 1) < Island.instance.getXSize()) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX() + 1, coordinates.getY()));
        }
        if (coordinates.getY() + 1 < Island.instance.getYSize()) {
            accessibleCells.add(Island.instance.getCell(coordinates.getX(), coordinates.getY() + 1));
        }
        do {
            if (animal.getCurrentHanger() > animal.getCurrentHanger() / 2) {
                List<Animal> animalToBreed = chooseForBreed();
                if (!animalToBreed.isEmpty()) {
                    animal.breed(animalToBreed.get(0));
                } else {
                    animal.moveTo(choosingDirection());
                }
            } else if (animal.getCurrentHanger() < animal.getCurrentHanger()/2 && animal.getCurrentEnergy() > 0) {
                animal.eat();
                }
            } while (animal.getCurrentEnergy() > 1);
        }



    public Cell choosingDirection() {
        if(animal instanceof CarnivoreAnimal) { System.out.println(this + " выбирает направление");
        return accessibleCells.stream()
                .max(Comparator.comparing(Cell::getHerbivoreAnimalsQty))
                .orElse(Island.instance.getCell(animal.getPosition())); }
        else if (animal instanceof HerbivoreAnimal) {
            return accessibleCells.stream()
                    .min(Comparator.comparing(Cell::getCarnivoreAnimalsQty))
                    .orElse(Island.instance.getCell(animal.getPosition()));
        }
        else throw new RuntimeException("Неправильно задан тип животного");
    }

    public List<Animal> chooseForBreed() {
        Cell cell = Island.instance.getCell(animal.getPosition());
       return cell.getFauna().stream().filter(e -> e.getName().equals(animal.getName()) && !(e.equals(animal))).toList();
    }
}
