package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Moving;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;

import java.util.Comparator;


public abstract class CarnivoreAnimal extends Animal implements Moving {


    public CarnivoreAnimal(Coordinates position) {
        super(position);
    }

    public CarnivoreAnimal(int x, int y) {
        super(x, y);
    }

    @Override
    public Cell choosingDirection() {
            System.out.println(this + " выбирает направление");
            return this.getAccessibleCells().stream()
                    .max(Comparator.comparing(Cell::getHerbivoreAnimalsQty))
                    .orElseGet(() -> Island.instance.getCell(this.getPosition()));
    }

    @Override
    public void moveTo(Cell newCell) {
        super.moveTo(newCell);
    }
}

