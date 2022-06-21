package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;


@MaxCapacity(500)
@LuckNumber(8)
public class Mouse extends HerbivoreAnimal {
    {
        setName("Мышь");
    }


    public Mouse(int x, int y) {
        super(x, y);
        init();
    }

    public Mouse(Coordinates position) {
        super(position);
        init();
    }
}
