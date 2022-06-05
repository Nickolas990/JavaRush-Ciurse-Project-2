package Behaivior;

public interface Mortal {
    default void die() {
        System.out.println(this + "погиб");
    }
}
