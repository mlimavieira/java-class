package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter Board size");

        int BOARD_SIZE = sc.nextInt();

        Board board = new Board(BOARD_SIZE);
        board.printBoard();

        Random computer = new Random();
        boolean isPlayer = true;
        while (board.hasAvailableMove()) {

            if(isPlayer) {

                System.out.println("Please choose a number between 1 and " + BOARD_SIZE);
                int row = sc.nextInt();

                System.out.println("Please choose a number between 1 and " + BOARD_SIZE);
                int col = sc.nextInt();

                if( (row > BOARD_SIZE || row < 0 ) || (col > BOARD_SIZE || col < 0)) {
                    System.out.println("Please enter a valid move between 1 and " + BOARD_SIZE);
                    continue;
                }

                boolean moveResult = board.setPlayerMove(row -1, col -1);
                if (!moveResult) {
                    continue;
                }
            } else {

                int row = computer.nextInt(BOARD_SIZE);
                int column = computer.nextInt(BOARD_SIZE);

                boolean moveResult = board.setComputerMove(row, column);
                if (!moveResult) {
                    continue;
                }
            }

            board.printBoard();
            isPlayer = !isPlayer;

            if(board.hasWinner()) {
                break;
            }
        }

        if(board.getWinner() == "P") {
            System.out.println("Player won the game");
        } else {
            System.out.println("Computer won the game");
        }


    }




}



