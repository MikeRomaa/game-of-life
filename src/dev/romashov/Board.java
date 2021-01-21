package dev.romashov;

import dev.romashov.helpers.Blueprints;
import dev.romashov.helpers.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Board extends JPanel {
    private final Grid grid;
    private final GameOfLife game;
    private final int windowWidth;
    private final int windowHeight;
    private final int cellWidth;
    private boolean run;
    private boolean placingBlueprint;
    private int[] blueprintOrigin;
    private ArrayList<int[]> blueprintCells;

    public Board(int wWidth, int wHeight, int cWidth) {
        windowWidth = wWidth;
        windowHeight = wHeight;
        cellWidth = cWidth;
        grid = new Grid(wWidth / cellWidth, wHeight / cellWidth);
        game = new GameOfLife(grid);

        initializeBindings();
    }

    private void initializeBindings() {
        // Register event listener for mouse actions (click, drag, etc)
        MouseEventListener mouse = new MouseEventListener(this);
        this.addMouseMotionListener(mouse);
        this.addMouseListener(mouse);

        // Register key bindings for keyboard shortcuts
        InputMap input = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap action = this.getActionMap();
        input.put(KeyStroke.getKeyStroke("shift SPACE"), "run");
        input.put(KeyStroke.getKeyStroke("SPACE"), "step");
        input.put(KeyStroke.getKeyStroke("ENTER"), "stop");
        input.put(KeyStroke.getKeyStroke("1"), "b1");
        input.put(KeyStroke.getKeyStroke("2"), "b2");
        input.put(KeyStroke.getKeyStroke("R"), "rotate");
        action.put("run", new AbstractAction() {
            public void actionPerformed(ActionEvent e) { run = true; }
        });
        action.put("step", new AbstractAction() {
            public void actionPerformed(ActionEvent e) { if (!run) game.nextGeneration(); }
        });
        action.put("stop", new AbstractAction() {
            public void actionPerformed(ActionEvent e) { run = false; }
        });
        action.put("b1", new AbstractAction() {
            public void actionPerformed(ActionEvent e) { createBlueprint(Blueprints.GLIDER_GUN); }
        });
        action.put("b2", new AbstractAction() {
            public void actionPerformed(ActionEvent e) { createBlueprint(Blueprints.PUFFERFISH); }
        });
        action.put("rotate", new AbstractAction() {
            public void actionPerformed(ActionEvent e) { rotateBlueprint(); }
        });

        // Schedules game to advance by one generation every second
        Runnable advanceGame = () -> { if (run) game.nextGeneration(); };
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(advanceGame, 0, 50, TimeUnit.MILLISECONDS);
    }

    /**
     * Returns the matrix coordiante of the mouse.
     * @return integer array of matrix coordinate [x, y]
     */
    private int[] getMouseCell() {
        Point mouse = this.getMousePosition();
        return new int[]{(int) mouse.getX() / cellWidth, (int) mouse.getY() / cellWidth};
    }

    /**
     * Generates a blueprint for the desired structure and adds
     * it to the blueprintCells array to be rendered by {@link #paint}.
     * @param blueprint blueprint constant from {@link Blueprints} class
     */
    private void createBlueprint(ArrayList<int[]> blueprint) {
        blueprintCells = Blueprints.generateBlueprint(getMouseCell(), blueprint);
        blueprintOrigin = getMouseCell();
        placingBlueprint = true;
    }

    /**
     * Translates every cell of the current blueprint to the new pixel coordinate.
     * @param x new pixel x coordinate for blueprint origin
     * @param y new pixel y coordinate for blueprint origin
     */
    public void translateBlueprint(int x, int y) {
        int newX = x / cellWidth;
        int newY = y / cellWidth;
        blueprintCells = Utils.translatePoints(blueprintCells, newX - blueprintOrigin[0], newY - blueprintOrigin[1]);
        blueprintOrigin = new int[]{newX, newY};
    }

    /**
     * Rotates every cell of the current blueprint by 90 degrees.
     */
    public void rotateBlueprint() {
        blueprintCells = Utils.rotatePointsAroundCenter(blueprintCells, getMouseCell());
    }

    /**
     * Converts all blueprint cells to live cells.
     */
    public void placeBlueprint() {
        grid.setCells(blueprintCells, CellState.ALIVE);
        placingBlueprint = false;
        blueprintCells = null;
    }

    public boolean isPlacingBlueprint() {
        return placingBlueprint;
    }

    /**
     * Sets a cell at a given pixel coordinate to a {@link CellState}
     * enumerated state.<br>
     * <b>Precondition:</b> Cell must be within grid bounds.
     * @param x pixel x coordinate of cell (from left)
     * @param y pixel y coordinate of cell (from top)
     * @param state state to set cell to
     */
    public void setCellAtCoordinate(int x, int y, CellState state) {
        grid.setCell(x / cellWidth, y / cellWidth, state);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillRect(0, 0, windowWidth, windowHeight);

        // Iterates through every row (y-coordinate) in the grid
        for (int y = 0; y < grid.getHeight(); y++) {
            // Iterates through every column (x-coordinate) in the current row
            for (int x = 0; x < grid.getWidth(); x++) {
                // Alive cells are filled in and dead cells are left empty
                if (grid.getCell(x, y).getState() == CellState.ALIVE) {
                    g2d.setColor(Color.GREEN);
                } else if (grid.getCell(x, y).getState() == CellState.PATH) {
                    g2d.setColor(new Color(0, 10, 0));
                } else {
                    g2d.setColor(Color.BLACK);
                }
                g2d.fillRect(x * cellWidth, y * cellWidth, cellWidth, cellWidth);
            }
        }

        // Iterates through blueprint cells to draw border around them
        if (blueprintCells != null) {
            for (int[] cell : blueprintCells) {
                g2d.setColor(Color.GREEN);
                g2d.drawRect(cell[0] * cellWidth, cell[1] * cellWidth, cellWidth, cellWidth);
            }
        }
    }
}
