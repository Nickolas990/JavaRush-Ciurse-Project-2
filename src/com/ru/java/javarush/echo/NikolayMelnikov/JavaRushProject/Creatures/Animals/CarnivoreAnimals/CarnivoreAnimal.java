package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;


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
        Animal victim = chooseVictim();
        this.tryToEat(victim);
        reduceEnergy();
    }

}

