package fr.esgi;

public class Grid {

    private final Cell[][] grid;

    public Grid(int width, int height) {
        grid = new Cell[width][height];
    }

    public void addCell(int x, int y) {
        grid[x][y] = new Cell();
    }

}
