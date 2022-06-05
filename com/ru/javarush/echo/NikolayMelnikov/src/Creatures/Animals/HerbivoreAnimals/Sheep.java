package Creatures.Animals.HerbivoreAnimals;

public class Sheep extends HerbivoreAnimal {

    public Sheep(int[][] position) {
        super(position);
    }

    public Sheep(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 70;
        this.maxCapacityInCell = 140;
        this.energy = 3;
        this.hanger = 15;
    }
}
