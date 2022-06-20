package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Settings.AnimalCharacteristics;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Settings.Settings;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@MaxCapacity(5)
@LuckNumber(3)
public class Bear extends CarnivoreAnimal {


    {
        setName("Медведь");
    }

    public Bear(int x, int y) {
        super(x, y);
        init();
    }

    public Bear(Coordinates position) {
        super(position);
        init();
    }


}
