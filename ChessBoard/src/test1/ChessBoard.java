package test1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessBoard extends JFrame {
    private JPanel chessBoardPanel;
    private JButton[][] chessButtons;

    public ChessBoard() {
        setTitle("Chess Board");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chessBoardPanel = new JPanel();
        chessBoardPanel.setLayout(new GridLayout(8, 8));
        chessButtons = new JButton[8][8];

        // Create chess buttons and add them to the panel
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessButtons[i][j] = new JButton();
                chessBoardPanel.add(chessButtons[i][j]);

                // Set button background color based on the board pattern
                if ((i + j) % 2 == 0) {
                    chessButtons[i][j].setBackground(Color.WHITE);
                } else {
                    chessButtons[i][j].setBackground(Color.GRAY);
                }
            }
        }

        add(chessBoardPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChessBoard());
    }
}
