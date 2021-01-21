package dev.romashov;

public class GameOfLife {
    private Grid grid;

    public GameOfLife(Grid gameGrid) {
        grid = gameGrid;
    }

    /**
     * Goes through every cell on the grid and calls the {@link Cell#iterate}
     * method on each cell with the amount of live neighbors it
     * has (a neighbor is any cell within a 3x3 area of the cell).
     * Then updates the current grid with the next generation grid.
     */
    public void nextGeneration() {
        Window.incrementGeneration();

        Grid futureGrid = grid.copyGrid();
        for (int y = 0; y < grid.getHeight(); y++) {
            for (int x = 0; x < grid.getWidth(); x++) {
                Cell currentCell = grid.getCell(x, y);
                int liveNeighbors = 0;
                for (Cell cell : grid.getNeighbors(currentCell))
                    if (cell.getState() == CellState.ALIVE) liveNeighbors++;

                futureGrid.getCell(x, y).iterate(liveNeighbors);
            }
        }
        grid.setMatrix(futureGrid.getMatrix());
    }
}
