package fr.esgi;

public class Cell {
    private final int x;
    private final int y;
    private boolean alive;

    Cell(int x, int y, boolean alive) {
        this.x = x;
        this.y = y;
        this.alive = alive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAlive() {
        return alive;
    }

    public void live() {
        alive = true;
    }

    public void die() {
        alive = false;
    }

}
