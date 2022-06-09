package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Moving;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.Luck;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;


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
        this.energy--;
    }

    public Animal chooseVictim() {
        Cell cell = Island.instance.getCell(this.getPosition());
        return (Animal) cell.getFauna().stream().max(Comparator.comparing(Creature::getWeight)).orElseGet(null);
    }


    public void eat(Animal animal) {
        Integer luck = Luck.getLuck(this.getClass().getAnnotation(LuckNumber.class).value(), animal.getClass().getAnnotation(LuckNumber.class).value());
        if (ThreadLocalRandom.current().nextInt(0, 101) < luck) {
            System.out.println(String.format("%s съел %s", this.getName(), animal.getName()));
            this.hanger += animal.getWeight();
            animal.die();
            this.energy--;
        }
        this.energy--;
    }
}

