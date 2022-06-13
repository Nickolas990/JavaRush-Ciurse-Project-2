package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals.CarnivoreAnimal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals.HerbivoreAnimal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SoulOfAnimals implements Runnable{
    Animal animal;



    public SoulOfAnimals (Animal soul) {
        animal = soul;
    }




    @Override
    public void run() {
        do {
            act();
            } while (animal.getCurrentEnergy() > 0);
        }



    public Cell choosingDirectionForEat() {
        if(animal instanceof CarnivoreAnimal) { System.out.println(this + " выбирает направление");
        return animal.getAccessibleCells().stream()
                .max(Comparator.comparing(Cell::getHerbivoreAnimalsQty))
                .orElse(randomCell()); }
        else if (animal instanceof HerbivoreAnimal) {
            return animal.getAccessibleCells().stream()
                    .max(Comparator.comparing(Cell::getPlantsQty))
                    .orElse(randomCell());
        }
        else throw new RuntimeException("Неправильно задан тип животного");
    }

    public Cell choosingDirectionForBreed() {
        return animal.getAccessibleCells().stream()
                .filter(e -> e.getCurrentCapacityOfCell()
                        .containsKey(animal.getName()))
                .findFirst()
                .orElse(randomCell());

    }

    private Cell randomCell(){
        return animal.getAccessibleCells().get(ThreadLocalRandom.current().nextInt(0, animal.getAccessibleCells().size()));
    }

    public List<Animal> chooseForBreed() {
        Cell cell = Island.instance.getCell(animal.getPosition());
       return cell.getFauna().stream().filter(e -> e.getName().equals(animal.getName())
               && !(e.equals(animal)) && e.getCurrentEnergy() > 0).toList();
    }

    public void act() {
        Cell cell = Island.instance.getCell(animal.getPosition());
        if (animal.getCurrentHanger() < animal.getMaxHunger()*0.5) {
            if ( animal instanceof CarnivoreAnimal && cell.getHerbivoreAnimalsQty() > 0 ||
                    animal instanceof HerbivoreAnimal && cell.getPlantsQty() > 0) {
                animal.eat();
            } else {
                animal.moveTo(choosingDirectionForEat());
            }
        } else {
            List<Animal> breeders = chooseForBreed();
            if (!breeders.isEmpty()) {
                animal.breed(breeders.get(0));
            } else {
                animal.moveTo(choosingDirectionForBreed());
            }
        }
    }
}
