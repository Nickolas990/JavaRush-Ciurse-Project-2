package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior.Mortal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Field.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Field.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Field.Field;
import lombok.ToString;

@ToString
public abstract class Creature implements Mortal {
    Coordinates position;
    boolean isAlive;

    protected Creature (int x, int y) {
        position.setX(x);
        position.setY(y);
        comeToStartCell(position);
    }

    public Creature(Coordinates position) {
        this.position = position;
        comeToStartCell(position);
    }

    public Coordinates getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        position.setX(x);
        position.setY(y);
    }
    public void comeToStartCell(Coordinates position) {
        Cell cell = Field.instance.getCell(position.getX(), position.getY());
        cell.addCreatureInCell(this);
    }


    @Override
    public void die() {
        Mortal.super.die();
        isAlive = false;
    }
}
