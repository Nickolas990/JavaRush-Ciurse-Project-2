package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;

@MaxCapacity(10)
public class Buffalo extends HerbivoreAnimal {
    {
        setName("Буйвол");
    }


    public Buffalo(int x, int y) {
        super(x, y);
        init();
    }

    public Buffalo(Coordinates position) {
        super(position);
        init();
    }

}
