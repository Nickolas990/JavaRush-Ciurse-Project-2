package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.Luck;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.Randomizer;

import java.util.Comparator;
import java.util.List;


public abstract class CarnivoreAnimal extends Animal {


    public CarnivoreAnimal(Coordinates position) {
        super(position);
    }

    public CarnivoreAnimal(int x, int y) {
        super(x, y);
    }

    @Override
    public void moveTo(Cell newCell) {
        super.moveTo(newCell);
        reduceEnergy();
    }
    @Override
    public void eat() {
        Cell cell = Island.instance.getCell(getPosition());
        List<Animal> accessibleAnimals = cell.getFauna().stream()
                .filter(e -> Luck.getLuck(this
                                .getClass()
                                .getAnnotation(LuckNumber.class)
                                .value(),
                        e.getClass()
                                .getAnnotation(LuckNumber.class).value()) > 0)
                .toList();
        if (!accessibleAnimals.isEmpty()) {
            Animal victim = chooseVictim(accessibleAnimals);
            tryToEat(victim);
        } else {
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

