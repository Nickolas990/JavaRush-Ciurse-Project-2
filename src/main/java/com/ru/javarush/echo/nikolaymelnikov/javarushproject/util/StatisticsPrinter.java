package com.ru.javarush.echo.nikolaymelnikov.javarushproject.util;

import com.ru.javarush.echo.nikolaymelnikov.javarushproject.interfaces.Printer;
import com.ru.javarush.echo.nikolaymelnikov.javarushproject.island.Cell;
import com.ru.javarush.echo.nikolaymelnikov.javarushproject.island.Island;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class StatisticsPrinter implements Printer {

    public Map<String, Long> quantityOfAnimals = new ConcurrentHashMap<>();
    public Map<String, Long> quantityOfPlants = new ConcurrentHashMap<>();
    public AtomicInteger carnivoresQuantity = new AtomicInteger(0);
    public AtomicInteger herbivoresQuantity = new AtomicInteger(0);
    private ExecutorService service = Executors.newSingleThreadExecutor();
    public static final String NAME_OF_THREAD = "Statistics";
    public static final String SMILES_OR_EMOJI_MESSAGE = "What kind of statistics you want to see, names or emoji? Type the answer below";
    private static final String CARNIVORES_DEAD = "All carnivores are down. Please, stop tormenting this cursed world.";
    private static final String HERBIVORES_DEAD = "All herbivores died. We recommend that you stop torturing this weak world.";
    private static String answer = "";

    /**
     * If you want to use this StatisticsPrinter in another world, just change "island" parameter
     */
    private Island island = Island.getInstance();

    @Override
    public void print() {
        if (answer.isEmpty()) {
            while (!answer.equalsIgnoreCase("emoji") || !answer.equalsIgnoreCase("names")) {
                System.out.println(SMILES_OR_EMOJI_MESSAGE);
                answer = new Scanner(System.in).nextLine();
            }
        }

        Thread.currentThread().setName(NAME_OF_THREAD);
        quantityOfPlants.clear();
        quantityOfAnimals.clear();
        carnivoresQuantity.set(0);
        herbivoresQuantity.set(0);

        for (int x = 0; x < island.getWight(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                Cell cell = island.getCell(x, y);
                service.submit(() -> {
                    if ("emoji".equalsIgnoreCase(answer)) {
                        getStatisticsWithEmoji(cell);
                    } else {
                        getStatisticsWithNames(cell);
                    }
                });
        }
    }
        try {
            service.awaitTermination(ExecutorsAwaitingConstants.STATISTIC_PRINTER_AWAITING, TimeUnit.SECONDS);
            service.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e + " " + "StatisticsPrinter is interrupted");
        }
        quantityOfAnimals.forEach((k,v)->System.out.println(k +" : "+v ));
        System.out.println();
        quantityOfPlants.forEach((k,v)->System.out.println(k +" : "+v ));
        if (carnivoresQuantity.get() == 0) {
            System.out.println(CARNIVORES_DEAD);

        } else if (herbivoresQuantity.get() == 0) {
            System.out.println(HERBIVORES_DEAD);
        }
    }

    private void getStatisticsWithEmoji(Cell cell) {
        cell.getFauna().forEach(e -> quantityOfAnimals.merge(e.getEmoji(), 1L, Long::sum));
        cell.getFlora().forEach(e -> quantityOfPlants.merge(e.getEmoji(), 1L, Long::sum));
        carnivoresQuantity.addAndGet(cell.getCarnivoreAnimalsQuantity());
        herbivoresQuantity.addAndGet(cell.getHerbivoreAnimalsQuantity());
    }
    private void getStatisticsWithNames(Cell cell) {
        cell.getFauna().forEach(e -> quantityOfAnimals.merge(e.getName(), 1L, Long::sum));
        cell.getFlora().forEach(e -> quantityOfPlants.merge(e.getName(), 1L, Long::sum));
        carnivoresQuantity.addAndGet(cell.getCarnivoreAnimalsQuantity());
        herbivoresQuantity.addAndGet(cell.getHerbivoreAnimalsQuantity());
    }
}
