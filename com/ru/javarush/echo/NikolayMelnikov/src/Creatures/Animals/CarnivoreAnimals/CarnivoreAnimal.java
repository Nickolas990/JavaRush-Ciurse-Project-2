package Creatures.Animals.CarnivoreAnimals;

import Creatures.Animals.Animal;

public abstract class CarnivoreAnimal extends Animal {


    public CarnivoreAnimal(int[][] position) {
        super(position);
    }

    public CarnivoreAnimal(int x, int y) {
        super(x, y);
    }
}
