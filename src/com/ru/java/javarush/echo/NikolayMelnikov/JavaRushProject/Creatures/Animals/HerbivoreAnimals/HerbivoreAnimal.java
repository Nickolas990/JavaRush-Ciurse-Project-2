package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;

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
    public Cell choosingDirection() {
        System.out.println(this + " выбирает направление");

        return this.getAccessibleCells().stream()
                .min(Comparator.comparing(Cell::getCarnivoreAnimalsQty))
                .orElseGet(() -> Island.instance.getCell(this.getPosition()));
    }
}
