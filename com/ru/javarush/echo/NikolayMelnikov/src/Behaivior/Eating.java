package Behaivior;

import Creatures.Creature;

public interface Eating {
    default void eat (Creature creature) {
        System.out.println(String.format(" %s ���� %s", this, creature));
    }
}
