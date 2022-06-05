package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Breeding;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Eating;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Moving;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Field.Coordinates;
import lombok.Getter;

@Getter
public abstract class Animal extends Creature implements Moving, Eating, Breeding {
    protected double weight;
    protected int maxCapacityInCell;
    protected int energy;
    protected double hanger;

    public Animal(Coordinates position) {
        super(position);
    }
    public Animal (int x, int y) {
        super(new Coordinates(x, y));
    }
}
