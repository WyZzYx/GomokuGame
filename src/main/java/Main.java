import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private Board board;
    private Settings settings;


/*
        GAME RULES:
        Gomoku(also called 5 in row) is a japanese name of a traditional chinese abstract strategy game.

        The game is played with a Go pieces on a board 15x15, but for fast games 9x9 board is used, for long games 19x19.
        Black start first. They place a stone on a grid.
        Then White place their.
        First player to set an unbroken line of 5(or more) stones of his colour in a row/vertical/diagonal wins
        To achieve a tie, the whole board should be filled with stones.
*/

    public Main() {
        board = new Board();
        settings = new Settings(board);


        setTitle("Gomoku Game");
        setSize(1200, 1200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());




        add(board, BorderLayout.CENTER);
        add(settings.settingsPanel, BorderLayout.EAST);


    }

    private native boolean fiveInRow();
    static native int gameState();
    static native void setBoardSize(int size);
    static native void mouseClicked(int x, int y);
    static native void keyPressed(char key);
    static native int getBoardState(int x, int y);
    static native int getBoardSize();





    public static void main(String[] args) {
        System.load("/Users/vitaliikoltok/CLionProjects/UTPProjectGomoku/cmake-build-debug/libUTPProjectGomoku.dylib");
//        System.loadLibrary("libUTPProjectGomoku");
        SwingUtilities.invokeLater(() -> {
            Main gui = new Main();
            gui.setVisible(true);
        });
    }
}
