package Creatures.Animals.HerbivoreAnimals;

public class Deer extends HerbivoreAnimal {

    public Deer(int[][] position) {
        super(position);
    }

    public Deer(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 300;
        this.maxCapacityInCell = 20;
        this.energy = 4;
        this.hanger = 50;
    }
}
