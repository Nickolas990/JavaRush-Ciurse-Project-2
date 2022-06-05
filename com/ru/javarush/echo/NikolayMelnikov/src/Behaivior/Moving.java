package Behaivior;

public interface Moving {
    default void move() {
        System.out.println("Выбрано направление движения");
    }
}
