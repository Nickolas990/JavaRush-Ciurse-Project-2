package Creatures.Animals.CarnivoreAnimals;

import com.ru.java.javarush.echo.NikolayMelnikov.JavaRushProject.Creatures.Animals.CarnivoreAnimals.CarnivoreAnimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bear extends CarnivoreAnimal {

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
