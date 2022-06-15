package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Creature;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.GrassSeeder;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util.Settings;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class Island {

    public static final Island instance = new Island();

    Cell[][] island;
    private int xSize = Settings.XSize;
    private int ySize = Settings.YSize;



    private Island() {
        island = new Cell[xSize][ySize];
        initialiseIsland();

    }

    public static Island createNewStandardField() {
        return instance;
    }

    public void addAnimal(Animal animal) {
        Cell cell = getCell(animal.getPosition());
        cell.addAnimalInCell(animal);
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
