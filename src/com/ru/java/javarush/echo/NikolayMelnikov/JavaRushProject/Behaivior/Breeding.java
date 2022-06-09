package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Behaivior;


import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.Animal;

public interface Breeding {
    Animal chooseForBreed();
    void breed(Animal animal);
}
