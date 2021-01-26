package dev.romashov.gameOfLife;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private static long generation;
    private static JLabel genCount;

    public Window(int width, int height) {
        // Setting initial parameters for the window
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Conway's Game of Life");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // Adding generation count label
        genCount = new JLabel("Generation: ");
        genCount.setForeground(Color.WHITE);
        genCount.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        genCount.setBounds(20, 20, 500, 20);
        this.add(genCount);

        // Adding game board
        Board panel = new Board(2000, 1500, 10);
        panel.setBounds(0, 0, 2000, 1500);
        this.add(panel);
    }

    public static void incrementGeneration() {
        generation++;
        genCount.setText("Generation: " + generation);
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
