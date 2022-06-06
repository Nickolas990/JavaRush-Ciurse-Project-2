package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Mortal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class Creature implements Mortal {
    Coordinates position;
    boolean isAlive = true;
    protected String name;

    protected Creature (int x, int y) {
        position.setX(x);
        position.setY(y);

    }

    public Creature(Coordinates position) {
        this.position = position;

    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        position.setX(x);
        position.setY(y);
    }


    @Override
    public void die() {
        Mortal.super.die();
        isAlive = false;
    }

    @Override
    public String toString() {
        return "{" + name +
                '}';
    }
}
