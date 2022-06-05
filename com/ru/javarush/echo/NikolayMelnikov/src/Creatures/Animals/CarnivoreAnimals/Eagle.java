package Creatures.Animals.CarnivoreAnimals;

public class Eagle extends CarnivoreAnimal {

    public Eagle(int[][] position) {
        super(position);
    }

    public Eagle(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 6;
        this.maxCapacityInCell = 20;
        this.energy = 3;
        this.hanger = 1;
    }
}
