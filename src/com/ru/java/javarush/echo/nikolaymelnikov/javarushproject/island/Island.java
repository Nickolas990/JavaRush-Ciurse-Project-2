package com.ru.java.javarush.echo.nikolaymelnikov.javarushproject.island;

import com.ru.java.javarush.echo.nikolaymelnikov.javarushproject.settings.AnimalCharacteristics;
import com.ru.java.javarush.echo.nikolaymelnikov.javarushproject.settings.Settings;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Island {

    static {
        instance = new Island();
    }
    public static Island getInstance() {
        return instance;
    }
    private static Island instance;
    private Settings settings = Settings.initialize();

    private int wight = settings.getWight();
    private int height = settings.getHeight();
    Cell[][] island = new Cell[wight][height];
    AnimalCharacteristics[] animalCharacteristics = settings.getAnimalCharacteristics();

    public Cell getCell(int x, int y) {
        return island[x][y];
    }
    public Cell getCell (Coordinates position) {
        return island[position.getX()][position.getY()];
    }

    private void initialiseIsland() {
        for (int x = 0; x < wight; x++) {
            for (int y = 0; y < height; y++) {
                island[x][y] = new Cell(x, y);
            }
        }
    }
    public void getIslandInfo() {
        for (int x = 0; x < getWight(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                System.out.println(getCell(x, y));
            }
        }
    }
    private Island() {
        initialiseIsland();
    }

}
