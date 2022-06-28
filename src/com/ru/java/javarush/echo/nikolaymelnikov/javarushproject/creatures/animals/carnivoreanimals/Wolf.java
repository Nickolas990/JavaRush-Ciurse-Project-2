package com.ru.java.javarush.echo.nikolaymelnikov.javarushproject.creatures.animals.carnivoreanimals;

import com.ru.java.javarush.echo.nikolaymelnikov.javarushproject.annotations.MaxCapacity;
import com.ru.java.javarush.echo.nikolaymelnikov.javarushproject.island.Coordinates;
import com.ru.java.javarush.echo.nikolaymelnikov.javarushproject.island.Island;

@MaxCapacity(30)
public class Wolf extends CarnivoreAnimal {

    public Wolf(Coordinates position, Island island) {
        super(position, island);
        init();
    }

}
