package dev.romashov.gameOfLife;

public class Cell {
    private CellState state;
    private int x;
    private int y;

    public Cell(int xPos, int yPos) {
        state = CellState.DEAD;
        x = xPos;
        y = yPos;
    }

    public Cell(int xPos, int yPos, CellState initState) {
        state = initState;
        x = xPos;
        y = yPos;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState newState) {
        state = newState;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Cell copy() {
        return new Cell(x, y, state);
    }

    /**
     * Determines the next state of the cell by following four basic rules:
     * <ul>
     *     <li>If a live cell is surrounded by 2 or 3 live cells, the cell lives.</li>
     *     <li>If a live cell is surrounded by fewer than 2 live cells, it dies from underpopulation.</li>
     *     <li>If a live cell is surrounded by more than 3 live cells, it dies from overpopulation.</li>
     *     <li>If a dead cell is surrounded by exactly 3 live cells, it becomes live from reproduction.</li>
     * </ul>
     * @param liveNeighbors amount of live neighbor cells
     */
    public void iterate(int liveNeighbors) {
        // Cell dies from overpopulation
        if (state == CellState.ALIVE && liveNeighbors > 3) setState(CellState.PATH);
        // Cell dies from underpopulation
        else if (state == CellState.ALIVE && liveNeighbors < 2) setState(CellState.PATH);
        // Cell is born from reproduction
        else if (state != CellState.ALIVE && liveNeighbors == 3) setState(CellState.ALIVE);
    }
}
