package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Field;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Field {

    public static final Field instance = new Field();

    Cell[][] field;
    private int xSize = 100;
    private int ySize = 20;


    private Field() {
        field = new Cell[xSize][ySize];
        initialiseField();
    }

    public Field createNewStandardField() {
        return instance;
    }

    public Cell getCell(int x, int y) {
        return field[x][y];
    }

    private void initialiseField() {
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                field[i][j] = new Cell(i, j);
            }
        }
    }
}
