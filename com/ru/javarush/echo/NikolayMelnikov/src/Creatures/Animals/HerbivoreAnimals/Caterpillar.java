package Creatures.Animals.HerbivoreAnimals;

public class Caterpillar extends HerbivoreAnimal {

    public Caterpillar(int[][] position) {
        super(position);
    }

    public Caterpillar(int x, int y) {
        super(x, y);
    }
    {
        this.weight = 0.01;
        this.maxCapacityInCell = 1000;
        this.energy = 0;
        this.hanger = 0;
    }
}
