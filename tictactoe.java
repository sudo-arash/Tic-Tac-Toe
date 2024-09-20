import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

enum Player { X, O }

class TicTacToe implements ActionListener {
    private JFrame frame;
    private JTextField currentPlayerField;
    private JButton[][] buttons;
    private JButton resetButton;
    private int[][] cellState;
    private int moveCount;
    private Player currentPlayer;

    TicTacToe() {
        frame = new JFrame("Tic-Tac-Toe");
        currentPlayerField = new JTextField(20);
        currentPlayerField.setHorizontalAlignment(JTextField.CENTER);
        resetButton = new JButton("Reset");
        buttons = new JButton[3][3];
        cellState = new int[3][3];
        moveCount = 0;
        currentPlayer = Player.X;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(this);
            }
        }

        resetButton.addActionListener(this);

        frame.setLayout(new GridLayout(4, 3));
        frame.add(currentPlayerField);
        frame.add(resetButton);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                frame.add(buttons[i][j]);
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) e.getSource();
            int row = -1, col = -1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (buttons[i][j] == clickedButton) {
                        row = i;
                        col = j;
                        break;
                    }
                }
            }

            if (row != -1 && col != -1 && cellState[row][col] == 0) {
                cellState[row][col] = (currentPlayer == Player.X) ? 1 : 2;
                moveCount++;
                updateButton(row, col);
                checkWinCondition();
                currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
            }
        } else if (e.getSource() == resetButton) {
            resetGame();
        }
    }

    private void updateButton(int row, int col) {
        buttons[row][col].setText((currentPlayer == Player.X) ? "X" : "O");
        buttons[row][col].setEnabled(false);
        currentPlayerField.setText((currentPlayer == Player.X) ? "O's Turn" : "X's Turn");
    }

    private void checkWinCondition() {
        // Check rows, columns, and diagonals for win conditions
        for (int i = 0; i < 3; i++) {
            if (cellState[i][0] != 0 && cellState[i][0] == cellState[i][1] && cellState[i][1] == cellState[i][2]) {
                declareWinner(cellState[i][0]);
                return;
            }
            if (cellState[0][i] != 0 && cellState[0][i] == cellState[1][i] && cellState[1][i] == cellState[2][i]) {
                declareWinner(cellState[0][i]);
                return;
            }
        }
        if (cellState[0][0] != 0 && cellState[0][0] == cellState[1][1] && cellState[1][1] == cellState[2][2]) {
            declareWinner(cellState[0][0]);
            return;
        }
        if (cellState[0][2] != 0 && cellState[0][2] == cellState[1][1] && cellState[1][1] == cellState[2][0]) {
            declareWinner(cellState[0][2]);
            return;
        }

        // Check for a draw
        if (moveCount == 9) {
            currentPlayerField.setText("It's a draw!");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    buttons[i][j].setEnabled(false);
                }
            }
        }
    }

    private void declareWinner(int player) {
        String winner = (player == 1) ? "X wins!" : "O wins!";
        currentPlayerField.setText(winner);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    private void resetGame() {
        currentPlayerField.setText("X's Turn");
        currentPlayer = Player.X;
        moveCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cellState[i][j] = 0;
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToe());
    }
}
