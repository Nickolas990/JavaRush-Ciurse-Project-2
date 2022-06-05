package Creatures.Animals.CarnivoreAnimals;

public class Wolf extends CarnivoreAnimal {

    public Wolf(int[][] position) {
        super(position);
    }

    public Wolf(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 50;
        this.maxCapacityInCell = 30;
        this.energy = 3;
        this.hanger = 8;
    }
}
