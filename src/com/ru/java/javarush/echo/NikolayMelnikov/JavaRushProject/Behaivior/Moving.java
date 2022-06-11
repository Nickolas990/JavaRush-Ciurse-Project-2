package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;

public interface Moving {
    void moveTo(Cell newCell);
}
