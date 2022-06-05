package Creatures.Grass;

import Creatures.Creature;

public class Plant extends Creature {
    int weight;
    int maxCapacityInCell;

    public Plant(int[][] position) {
        super(position);
    }

    public Plant (int x, int y) {
        super(new int[][]{{x, y}});
    }

    {
        this.weight = 1;
        this.maxCapacityInCell = 200;
    }
}
