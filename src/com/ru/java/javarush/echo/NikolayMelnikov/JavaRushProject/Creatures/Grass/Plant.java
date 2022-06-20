package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Grass;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Interfaces.Mortal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import lombok.Getter;

@MaxCapacity(200)
@Getter
public class Plant extends Creature implements Mortal {
    int maxCapacityInCell;

    public Plant(Coordinates position) {
        super(position);
    }

    public Plant(int x, int y) {
        super(x, y);
    }

    {
        name = "Растение";
        weight = 1;
        maxCapacityInCell = 200;
    }

    @Override
    public void die() {
        super.die();
    }

    @Override
    public void leaveCell() {
        Cell cell = Island.getInstance().getCell(getPosition());
        cell.getFlora().remove(this);
        cell.getQtyOfGrass().merge(getName(), 1L, (oldVal, newVal) -> oldVal - newVal);
        if (cell.getQtyOfGrass().get(getName()) < 0) {
            cell.getQtyOfGrass().remove(getName());
        }
        cell.removeThis(this);

    }
}
