package Creatures.Animals;

import Behaivior.Breeding;
import Behaivior.Eating;
import Behaivior.Moving;
import Creatures.Creature;
import Field.Cell;
import Field.Coordinates;
import Field.Field;
import lombok.Getter;

@Getter
public abstract class Animal extends Creature implements Moving, Eating, Breeding {
    protected double weight;
    protected int maxCapacityInCell;
    protected int energy;
    protected double hanger;

    public Animal(Coordinates position) {
        super(position);
    }
    public Animal (int x, int y) {
        super(new Coordinates(x, y));
    }
}
