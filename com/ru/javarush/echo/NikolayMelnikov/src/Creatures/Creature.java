package Creatures;

public abstract class Creature {
    int [][] position;

    public int[][] getPosition() {
        return position;
    }

    public void setPosition(int[][] position) {
        this.position = position;
    }

    protected Creature (int [][] position) {
        this.position = position;
    }
}
