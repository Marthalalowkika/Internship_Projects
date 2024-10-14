import java.util.Scanner;

public class TicTacToeSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            char[][] board = new char[3][3];
            initializeBoard(board);
            char currentPlayer = 'X';
            boolean gameWon = false;
            boolean gameDraw = false;

            System.out.println("Welcome to Tic-Tac-Toe!");

            // Game loop
            while (!gameWon && !gameDraw) {
                displayBoard(board);
                playerMove(board, currentPlayer, scanner);
                gameWon = checkWin(board);
                gameDraw = checkDraw(board);

                if (gameWon) {
                    displayBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                } else if (gameDraw) {
                    displayBoard(board);
                    System.out.println("It's a draw!");
                } else {
                    // Switch player turns
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }

            // Ask if players want to play again, using a switch statement to handle responses
            System.out.println("Do you want to play again? Enter 1 for Yes, 2 for No: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    playAgain = true;
                    break;
                case 2:
                    playAgain = false;
                    System.out.println("Thanks for playing! Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice. Exiting the game.");
                    playAgain = false;
                    break;
            }
        }
    }

    // Initialize the board with empty spaces
    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Display the current state of the board
    private static void displayBoard(char[][] board) {
        System.out.println("  0   1   2 ");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            if (i < 2) System.out.println("\n ---|---|---");
        }
        System.out.println();
    }

    // Handle the player's move
    private static void playerMove(char[][] board, char currentPlayer, Scanner scanner) {
        int row, col;
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    // Check if there's a winner
    private static boolean checkWin(char[][] board) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    // Check if the game is a draw
    private static boolean checkDraw(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // There's still an empty space, no draw
                }
            }
        }
        return true; // No more empty spaces, it's a draw
    }
}
