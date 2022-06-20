package com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Util;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Interfaces.Printer;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Cell;
import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Island.Island;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class StatisticsPrinter implements Printer {
    public Map<String, Long> quantityOfAnimals = new ConcurrentHashMap<>();
    public Map<String, Long> quantityOfPlants = new ConcurrentHashMap<>();
    public AtomicInteger carnivoresQuantity = new AtomicInteger(0);
    public AtomicInteger herbivoresQuantity = new AtomicInteger(0);
    ExecutorService service = Executors.newCachedThreadPool();

    @Override
    public void print() {
        quantityOfPlants.clear();
        quantityOfAnimals.clear();
        carnivoresQuantity.set(0);
        ;
        herbivoresQuantity.set(0);
        for (int i = 0; i < Island.getInstance().getXSize(); i++) {
            for (int j = 0; j < Island.getInstance().getYSize(); j++) {
                Cell cell = Island.getInstance().getCell(i, j);
                service.submit(() -> {

                    cell.getCreaturesInCell().entrySet().stream().forEach(e -> quantityOfAnimals.merge(e.getKey(), e.getValue(), (o, n) -> o + n));
                    cell.getQtyOfGrass().entrySet().stream().forEach(e -> quantityOfPlants.merge(e.getKey(), e.getValue(), (o, n) -> o + n));
                    carnivoresQuantity.addAndGet(cell.getCarnivoreAnimalsQty());
                    herbivoresQuantity.addAndGet(cell.getHerbivoreAnimalsQty());
            });
        }
    }
        quantityOfAnimals.forEach((k,v)->System.out.println(k +" : "+v ));
        System.out.println();
        quantityOfPlants.forEach((k,v)->System.out.println(k +" : "+v ));
}
}
