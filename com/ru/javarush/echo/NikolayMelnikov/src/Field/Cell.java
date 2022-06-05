package Field;

import Creatures.Creature;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Cell {

    private Coordinates coordinates;
    protected Map<Creature, Integer> animalsInCell = new HashMap<>();

    public Cell(int x, int y) {
        coordinates.setX(x);
        coordinates.setY(y);
    }

    public void addCreatureInCell (Creature creature) {
        if (animalsInCell.containsKey(creature)) {
            animalsInCell.put(creature, 1);
        } else {
            Integer value = animalsInCell.get(creature);
            animalsInCell.put(creature, value++);
        }
    }


    public class CellInfo {

    }
}
