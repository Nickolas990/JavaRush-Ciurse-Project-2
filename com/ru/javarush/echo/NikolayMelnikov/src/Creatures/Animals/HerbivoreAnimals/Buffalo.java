package Creatures.Animals.HerbivoreAnimals;

import lombok.Generated;

@Generated
public class Buffalo extends HerbivoreAnimal {
    public Buffalo(int[][] position) {
        super(position);
    }

    public Buffalo(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 700;
        this.maxCapacityInCell = 10;
        this.energy = 3;
        this.hanger = 100;
    }

}
