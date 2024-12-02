import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JPanel implements MouseListener, KeyListener {
    public int cellSize;



    public Board() {
        setBackground(Color.LIGHT_GRAY);
        setFocusable(true);
        addMouseListener(this);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        cellSize = Math.min(getHeight(), getWidth()) / Main.getBoardSize();
        drawGrid(g);
        drawStones(g);
        revalidate();
        repaint();
    }

    private void drawGrid(Graphics g) {
        g.setColor(Color.BLACK);
        for (int i = 0; i <= Main.getBoardSize(); i++) {
            // Vertical lines
            g.drawLine(i * cellSize, 0, i * cellSize, Main.getBoardSize() * cellSize);
            // Horizontal lines
            g.drawLine(0, i * cellSize, Main.getBoardSize() * cellSize, i * cellSize);
        }
    }

    private void drawStones(Graphics g) {
        for (int x = 0; x < Main.getBoardSize(); x++) {
            for (int y = 0; y < Main.getBoardSize(); y++) {
                if (Main.getBoardState(x, y) != 0) {
                    if (Main.getBoardState(x, y) == 1) {
                        g.setColor(Color.BLACK);
                    } else if (Main.getBoardState(x, y) == 2) {
                        g.setColor(Color.WHITE);
                    } else if (Main.getBoardState(x, y) == 3) {
                        g.setColor(Color.DARK_GRAY);
                    } else if (Main.getBoardState(x, y) == 4) {
                        g.setColor(Color.PINK);
                    }
                    g.fillOval(x * cellSize, y * cellSize, cellSize, cellSize);
                }
            }
        }
    }

    public void gameFinished() {
        if(Main.gameState() == 1){
            JOptionPane.showMessageDialog(this, "Black Won!");
        }
        if(Main.gameState() == 2){
            JOptionPane.showMessageDialog(this, "White Won!");
        }
        if(Main.gameState() == 3){
            JOptionPane.showMessageDialog(this, "Tie!");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e) && Main.gameState() == 0) {
            int y = e.getY() / cellSize;
            int x = e.getX() / cellSize;

            if(x>=0 && x < Main.getBoardSize() && y>=0 && y < Main.getBoardSize()) {
                Main.mouseClicked(x, y);            }
            repaint();
        }
        gameFinished();

    }


    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_W) { // go up
            Main.keyPressed('w');

        }
            if(e.getKeyCode() == KeyEvent.VK_S){
                Main.keyPressed('s');

            }
            if(e.getKeyCode() == KeyEvent.VK_D){
                Main.keyPressed('d');

            }
            if(e.getKeyCode() == KeyEvent.VK_A){
                Main.keyPressed('a');

            }
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            Main.keyPressed('e');
            gameFinished();


        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}


