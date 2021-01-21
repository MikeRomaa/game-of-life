package dev.romashov;

public class Main {
    public static void main(String[] args) {
        Window window = new Window(1920, 1080);
        window.setVisible(true);
        while (true) {
            window.repaint();
        }
    }
}
