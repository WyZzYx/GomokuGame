import javax.swing.*;
import java.awt.*;

public class Settings extends JPanel {
    JPanel settingsPanel;
    private Board board;

    public Settings(Board board) {

        this.board = board;
        settingsPanel = new JPanel();
        settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.X_AXIS));
        settingsPanel.setBackground(Color.lightGray);



        createSettingsPanel();
    }

    void createSettingsPanel() {

        JLabel boardSizeText = new JLabel("Board Size:" );




        JButton smallButton = new JButton("9x9");
        JButton mediumButton = new JButton("15x15");
        JButton largeButton = new JButton("19x19");


        Dimension buttonSize = new Dimension(90, 50);
        boardSizeText.setPreferredSize(buttonSize);
        smallButton.setSize(buttonSize);
        mediumButton.setPreferredSize(buttonSize);
        largeButton.setPreferredSize(buttonSize);



        boardSizeText.setAlignmentY(Component.TOP_ALIGNMENT);
        smallButton.setAlignmentY(Component.TOP_ALIGNMENT);
        mediumButton.setAlignmentY(Component.TOP_ALIGNMENT);
        largeButton.setAlignmentY(Component.TOP_ALIGNMENT);


        smallButton.addActionListener(e -> {
            Main.setBoardSize(9);

            board.requestFocus();
            board.revalidate();
            board.repaint();
        });
        mediumButton.addActionListener(e ->  {
            Main.setBoardSize(15);

            board.requestFocus();
            board.revalidate();
            board.repaint();
        });
        largeButton.addActionListener(e -> {
            Main.setBoardSize(19);

            board.requestFocus();
            board.revalidate();
            board.repaint();
        });


        settingsPanel.add(boardSizeText);
        settingsPanel.add(smallButton);
        settingsPanel.add(mediumButton);
        settingsPanel.add(largeButton);


        revalidate();
        repaint();
    }
}
