package com.company;

public class Board {

    final String[][] board;
    final int boardSize;

    String winner = null;
    public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new String[boardSize][boardSize];
        initBoardMoves();
    }

    public String getWinner() {
        return winner;
    }

    public boolean hasWinner() {
        String result = WinnerChecker.hasWinner(board);
        winner = result;
        return result != null && result != "";
    }

    public boolean hasAvailableMove() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == null || board[i][j] == "") {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean setPlayerMove(int row, int column) {

        if (isValidMove(row, column)) {
            board[row][column] = "P";
            return true;
        }

        return false;
    }

    public boolean setComputerMove(int row, int column) {

        if (isValidMove(row, column)) {
            board[row][column] = "C";
            return true;
        }

        return false;
    }

    public void printBoard() {

        System.out.print("  ");
        for (int i = 1; i <= boardSize; i++) {
            System.out.print(i + "   ");
        }
        for (int row = 0; row < boardSize; row++) {

            System.out.println("");
            System.out.println("-".repeat(boardSize * 4));

            for (int column = 0; column < boardSize; column++) {

                if (board[row][column] == "") {
                    System.out.print("| " + " " + " ");
                } else {
                    System.out.print("| " + board[row][column] + " ");
                }

            }

            System.out.print("| " + (row + 1));
        }
        System.out.println("");
        System.out.println("-".repeat(boardSize * 4));
    }


    private void initBoardMoves() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = "";
            }
        }
    }

    private boolean isValidMove(int x, int y) {
        String currentPosition = board[x][y];
        if (currentPosition == null || currentPosition == "") {
            return true;
        }
        return false;
    }
}
