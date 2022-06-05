package Creatures.Animals.CarnivoreAnimals;



public class Boa extends CarnivoreAnimal{


    public Boa(int[][] position) {
        super(position);
    }

    public Boa(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 15;
        this.maxCapacityInCell = 30;
        this.energy = 1;
        this.hanger = 3;
    }
}
