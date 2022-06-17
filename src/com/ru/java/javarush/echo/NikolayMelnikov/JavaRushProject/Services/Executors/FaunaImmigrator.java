package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.Executors;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals.*;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.HerbivoreAnimals.*;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Services.AnimalDeployer;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FaunaImmigrator {
    private List<Runnable> listOfTasks = new ArrayList<>();
    public  void immigration() {

        listOfTasks.add(new AnimalDeployer(Bear.class));
        listOfTasks.add(new AnimalDeployer(Boa.class));
        listOfTasks.add(new AnimalDeployer(Eagle.class));
        listOfTasks.add(new AnimalDeployer(Fox.class));
        listOfTasks.add(new AnimalDeployer(Wolf.class));
        listOfTasks.add(new AnimalDeployer(Boar.class));
        listOfTasks.add(new AnimalDeployer(Buffalo.class));
        listOfTasks.add(new AnimalDeployer(Caterpillar.class));
        listOfTasks.add(new AnimalDeployer(Deer.class));
        listOfTasks.add(new AnimalDeployer(Duck.class));
        listOfTasks.add(new AnimalDeployer(Goat.class));
        listOfTasks.add(new AnimalDeployer(Horse.class));
        listOfTasks.add(new AnimalDeployer(Mouse.class));
        listOfTasks.add(new AnimalDeployer(Rabbit.class));
        listOfTasks.add(new AnimalDeployer(Sheep.class));

        ExecutorService service = Executors.newCachedThreadPool();

        listOfTasks.stream().forEach(e -> service.submit(e));

        service.shutdown();

        //Island.instance.getIslandInfo();
    }
}
