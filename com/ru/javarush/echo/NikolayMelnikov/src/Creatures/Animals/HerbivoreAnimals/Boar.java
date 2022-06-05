package Creatures.Animals.HerbivoreAnimals;

public class Boar extends HerbivoreAnimal {
    public Boar(int[][] position) {
        super(position);
    }

    public Boar(int x, int y) {
        super(x, y);
    }
    {
        this.weight = 400;
        this.maxCapacityInCell = 50;
        this.energy = 2;
        this.hanger = 50;
    }
}
