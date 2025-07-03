package fr.esgi;

public class Grid {

    private final int width;
    private final int height;
    private final Cell[][] grid;
    private int generation = 1;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Cell[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[x][y] = new Cell(x, y, false);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public int countNeighbours(Cell cell) {
        if (cell.getX() == 0 || cell.getX() == width - 1 || cell.getY() == 0 || cell.getY() == height - 1) return 0;

        int cells = 0;
        if (getCell(cell.getX() - 1, cell.getY() - 1).isAlive()) {
            cells++;
        }
        if (getCell(cell.getX(), cell.getY() - 1).isAlive()) {
            cells++;
        }
        if (getCell(cell.getX() + 1, cell.getY() - 1).isAlive()) {
            cells++;
        }

        if (getCell(cell.getX() - 1, cell.getY()).isAlive()) {
            cells++;
        }
        if (getCell(cell.getX() + 1, cell.getY()).isAlive()) {
            cells++;
        }

        if (getCell(cell.getX() - 1, cell.getY() + 1).isAlive()) {
            cells++;
        }
        if (getCell(cell.getX(), cell.getY() + 1).isAlive()) {
            cells++;
        }
        if (getCell(cell.getX() + 1, cell.getY() + 1).isAlive()) {
            cells++;
        }

        return cells;
    }

    public void print() {
        StringBuilder output = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                output.append(getCell(x, y).isAlive() ? '*' : '.');
            }
            output.append('\n');
        }
        System.out.print(output);
    }

    public void run() {
        print();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cell cell = grid[x][y];
                int neighbours = countNeighbours(cell);
                switch (neighbours) {
                    case 2, 3 -> cell.live();
                    default -> cell.die();
                }
            }
        }
        System.out.println();
        print();
    }

}
