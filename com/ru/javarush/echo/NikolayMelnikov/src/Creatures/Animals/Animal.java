package Creatures.Animals;

import Creatures.Creature;

public abstract class Animal extends Creature {
    public Animal(int[][] position) {
        super(position);
    }
    public Animal (int x, int y) {
        super(new int[][]{{x, y}});
    }
}
