package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.LuckNumber;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Annotations.MaxCapacity;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Coordinates;
import lombok.Getter;
import lombok.Setter;

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
