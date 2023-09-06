package test2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChessBoard extends JFrame {
    private JPanel chessBoardPanel;
    private JButton[][] chessButtons;
    private int selectedRow = -1;
    private int selectedCol = -1;

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

                // Add action listener to handle button clicks
                int row = i;
                int col = j;
                chessButtons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(row, col);
                    }
                });
            }
        }

        add(chessBoardPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void handleButtonClick(int row, int col) {
        if (selectedRow == -1 && selectedCol == -1) {
            // No piece is selected, check if there is a piece on the clicked button
            if (chessButtons[row][col].getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "No piece selected!", "Invalid Move", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Select the piece
            selectedRow = row;
            selectedCol = col;
            chessButtons[row][col].setBackground(Color.GREEN);
        } else {
            // A piece is already selected, handle the move
            // For simplicity, we'll just swap the pieces between the selected button and the clicked button
            String piece = chessButtons[selectedRow][selectedCol].getText();
            chessButtons[selectedRow][selectedCol].setText("");
            chessButtons[row][col].setText(piece);

            // Reset the selected button
            chessButtons[selectedRow][selectedCol].setBackground(chessButtons[selectedRow][selectedCol].getBackground());
            selectedRow = -1;
            selectedCol = -1;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChessBoard());
    }
}

