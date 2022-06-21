package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Settings.Settings;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Island {
    private static Island instance;

    static {
        instance = new Island();
    }
    public static Island getInstance() {
        return instance;
    }

    private Settings settings = Settings.initialize();

    public Settings getSettings() {
        return settings;
    }

    private int xSize = settings.wight;
    private int ySize = settings.height;
    Cell[][] island = new Cell[xSize][ySize];


    private Island() {
        initialiseIsland();
    }

    public Cell getCell(int x, int y) {
        return island[x][y];
    }
    public Cell getCell (Coordinates position) {
        return island[position.getX()][position.getY()];
    }

    private void initialiseIsland() {
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                island[i][j] = new Cell(i, j);
            }
        }
    }
    public void getIslandInfo() {
        for (int i = 0; i < getXSize(); i++) {
            for (int j = 0; j < getYSize(); j++) {
                System.out.println(getCell(i, j));
            }
        }
    }
}
