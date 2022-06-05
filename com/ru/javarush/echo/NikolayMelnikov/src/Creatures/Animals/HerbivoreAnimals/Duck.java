package Creatures.Animals.HerbivoreAnimals;

public class Duck extends HerbivoreAnimal {
    public Duck(int[][] position) {
        super(position);
    }

    public Duck(int x, int y) {
        super(x, y);
    }
    {
        this.weight = 1;
        this.maxCapacityInCell = 200;
        this.energy = 4;
        this.hanger = 0.15;
    }
}
