package Creatures.Animals.CarnivoreAnimals;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bear extends CarnivoreAnimal{


    public Bear(int[][] position) {
        super(position);
    }

    public Bear(int x, int y) {
        super(x, y);
    }

    {
        this.weight = 500;
        this.maxCapacityInCell = 5;
        this.energy = 2;
        this.hanger = 80;
    }

}
