package dev.romashov.gameOfLife;

public class Main {
    private static boolean run;

    public static void main(String[] args) {
        Window window = new Window(1920, 1080);
        System.out.println(window);
        window.setVisible(true);
        /*
         I'm aware this is a terrible way to do this, but I
         needed to integrate a return statement in a loop *somehow*.
         */
        while (true) {
            window.repaint();
            if (!run) return;
        }
    }

    public void stop() {
        run = false;
    };
}
