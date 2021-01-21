package dev.romashov;

import java.util.ArrayList;

public class Grid {
    private Cell[][] matrix;

    public Grid(int width, int height) {
        matrix = new Cell[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                matrix[y][x] = new Cell(x, y);
            }
        }
    }

    public Grid(Cell[][] state) {
        matrix = state;
    }

    public void setMatrix(Cell[][] newMatrix) {
        matrix = newMatrix;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public Cell getCell(int x, int y) {
        return matrix[y][x];
    }

    public void setCell(int x, int y, CellState state) {
        matrix[y][x].setState(state);
    }

    public void setCells(ArrayList<int[]> points, CellState state) {
        for (int[] point : points) {
            if (point[0] > -1 && point[0] < getWidth() && point[1] > -1 && point[1] < getHeight())
            this.setCell(point[0], point[1], state);
        }
    }

    public int getHeight() {
        return matrix.length;
    }

    public int getWidth() {
        return matrix[0].length;
    }

    /**
     * Given a cell, returns every cell in a 3x3 grid around it, excluding the initial cell.
     * @param origin origin {@link Cell}
     * @return {@link ArrayList} of neighboring cells
     */
    public ArrayList<Cell> getNeighbors(Cell origin) {
        ArrayList<Cell> neighbors = new ArrayList<>();

        for (int y = -1; y <= 1; y++)
            for (int x = -1; x <= 1; x++) {
                if (!(x == 0 && y == 0)) {
                    int newX = origin.getX() + x;
                    int newY = origin.getY() + y;
                    if (newY >= 0 && newY < getHeight() && newX >= 0 && newX < getWidth())
                        neighbors.add(getCell(newX, newY));
                }
            }

        return neighbors;
    }

    /**
     * Return a copy of the grid instance.
     * @return new {@link Grid} instance
     */
    public Grid copyGrid() {
        Cell[][] newMatrix = new Cell[getHeight()][getWidth()];

        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                newMatrix[y][x] = matrix[y][x].copy();
            }
        }

        return new Grid(newMatrix);
    }
}
