package dev.romashov.gameOfLife;

import javax.swing.*;
import java.awt.event.*;

public class MouseEventListener implements MouseListener, MouseMotionListener {
    private final Board board;

    public MouseEventListener(JPanel panel) {
        board = (Board) panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        try {
            if (SwingUtilities.isLeftMouseButton(e)) {
                if (board.isPlacingBlueprint()) {
                    board.placeBlueprint();
                } else {
                    board.setCellAtCoordinate(e.getX(), e.getY(), CellState.ALIVE);
                }
            }
            else if (SwingUtilities.isRightMouseButton(e)) {
                board.setCellAtCoordinate(e.getX(), e.getY(), CellState.DEAD);
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        try {
            if (SwingUtilities.isLeftMouseButton(e)) {
                board.setCellAtCoordinate(e.getX(), e.getY(), CellState.ALIVE);
            }
            else if (SwingUtilities.isRightMouseButton(e)) {
                board.setCellAtCoordinate(e.getX(), e.getY(), CellState.DEAD);
            }
            else if (SwingUtilities.isMiddleMouseButton(e)) {
                board.setBounds(
                        board.getBounds().x - e.getX(),
                        board.getBounds().y - e.getY(),
                        board.getWidth(),
                        board.getHeight()
                );
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {}
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (board.isPlacingBlueprint()) board.translateBlueprint(e.getX(), e.getY());
    }
}
