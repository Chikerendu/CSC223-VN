
package csc223.vn;

import java.util.Scanner;

public class TicTacToe implements Game {
    private char[][] board;
    private char currentPlayer;
    private Scanner scanner;

    public TicTacToe() {
        char[][] board = new char [3][3];
        board[0][0] = '-';
        board[0][1] = '-';
        board[0][2] = '-';
        
        board[1][0] = '-';
        board[1][1] = '-';
        board[1][2] = '-';
       
        board[2][0] = '-';
        board[2][1] = '-';
        board[2][2] = '-';
        currentPlayer = 'X';
        scanner = new Scanner(System.in);
    }
    public void startGame() {
        System.out.println("Please start TicTacToe");
    }
    public void printBoard() {
        for(char[] row : board) {
            System.out.println(row);
        }
    }
    public void takeTurn() {
        System.out.println("Player " + currentPlayer + "'s turn");
        System.out.println("Enter row and column (0-2): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if(board[row][col] == '-') {
            board[row][col] = currentPlayer;
            if(currentPlayer == 'X'){
                currentPlayer = 'O';
            } else {
                currentPlayer = 'X';
            }
        } else {
            System.out.println("Spot is not open, try again.");
        }
    }
    public boolean isGameOver() {
        for(int i = 0; i < 3; i++) {
            if(board [i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        for(int i = 0; i < 3; i++) {
            if(board [0][1] != '-' && board[0][1] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        if(board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if(board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        boolean isBoardFull = true;
        if(board[0][0] == '-' || board[0][1] == '-' || board[0][2] == '-'){
            isBoardFull = false;
        } else if(board[1][0] == '-' || board[1][1] == '-' || board[1][2] == '-'){
            isBoardFull = false;
        } else if(board[2][0] == '-' || board[2][1] == '-' || board[2][2] == '-'){
            isBoardFull = false; 
        }
        if(isBoardFull) {
            return true;
        }
        return false;
    }
    public void endGame() {
        System.out.println("Game Over!");
    } 
    public void playGame() {
        startGame();
        while(!isGameOver()){
            printBoard();
            takeTurn();
        }
        endGame();
    }
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}

