package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals.CarnivoreAnimal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Grass.Plant;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.Luck;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.Randomizer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class HerbivoreAnimal extends Animal {
    public HerbivoreAnimal(Coordinates position) {
        super(position);
    }

    public HerbivoreAnimal(int x, int y) {
        super(x, y);
    }

    @Override
    public void eat() {
        if (cell.getPlantsQty() > 0) {
            List<Animal> accessibleAnimals = cell.getFauna().stream()
                    .filter(e -> this.getLuck().get(e.getName()) > 0)
                    .toList();
            if (!accessibleAnimals.isEmpty()) {
                Animal victim = chooseVictim(accessibleAnimals);
                this.tryToEat(victim);
            } else  if (!cell.getFlora().isEmpty()){
                Plant plant = cell.getFlora().stream().findAny().get();
                plant.die();
                currentHanger +=10;
                if (currentHanger > maxHunger) {
                    currentHanger = maxHunger;
                }
            }
        } else {
            initializeAccessibleCells();
            moveTo(choosingDirectionForEat());
        }
        reduceEnergy();
    }
    public Cell choosingDirectionForEat() {
            return getAccessibleCells().stream()
                    .max(Comparator.comparing(Cell::getHerbivoreAnimalsQty))
                    .orElse(accessibleCells.get(Randomizer.randomize(0, accessibleCells.size())));
    }

}
