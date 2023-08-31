package com.aurionpro.model;

import java.util.Random;

public class BookGame {
    private String player1Name;
    private String player2Name;
    private int player1Score;
    private int player2Score;
    private int currentPlayer;

    public BookGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.currentPlayer = 1; 
    }

    public int getPlayer1Page() {
        Random random = new Random();
        int player1Page = random.nextInt(301);
        int player1Score = player1Page % 7;

        while (player1Score != 0) {
            player1Page++;
            player1Score = player1Page % 7;
        }

        return player1Page;
    }

    public int getPlayer2Score() {
        Random random = new Random();
        int player2Page = random.nextInt(301);
        int player2Score = player2Page % 7;

        while (player2Score != 0) {
            player2Page++;
            player2Score = player2Page % 7;
        }

        return player2Page; // Return the calculated page number
    }


    public void updatePlayerScore(int player, int score) {
        if (player == 1) {
            player1Score += score;
        } else {
            player2Score += score;
        }
    }

    public void displayScore(int player) {
        int score = (player == 1) ? player1Score : player2Score;
        System.out.println("Score: " + score);
    }

    public boolean isGameOver() {
        return player1Score >= 50 || player2Score >= 50;
    }

    public int determineWinner() {
        if (player1Score == player2Score) {
            return 0;
        } else if (player1Score > player2Score) {
            return 1; 
        } else {
            return 2; 
        }
    }

    public int getPlayerScore(int player) {
        return (player == 1) ? player1Score : player2Score;
    }
}
