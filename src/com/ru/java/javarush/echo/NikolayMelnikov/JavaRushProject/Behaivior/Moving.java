package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;

public interface Moving {
    default Cell choosingDirection() {
        System.out.println("Животное выбрало направление движения");
        return Island.instance.getCell(0,0);
    }

    void moveTo(Cell newCell);
}
