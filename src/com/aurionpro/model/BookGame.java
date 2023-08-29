package com.aurionpro.model;

import java.util.Random;

public class BookGame {
	public static void main(String[] args) {
		Random random = new Random();
		int bookPages = 300;

		// Player 1's turn
		int player1Page = random.nextInt(bookPages) + 1;
		int player1Score = player1Page % 7;

		while (player1Score != 0) {
			player1Page++;
			player1Score = player1Page % 7;
		}

		System.out.println("Player 1 Page: " + player1Page);
		System.out.println("Player 1 Score: " + player1Score);

		// Player 2's turn
		int player2Score = random.nextInt(7); // Player 2's score is between 0 and 6

		// Check for a tie
		if (player2Score == player1Score) {
			System.out.println("It's a tie!");
			return;
		}

		int player2Turns = 1;

		while (player2Score < player1Score) {
			player2Score += random.nextInt(7);
			player2Turns++;
		}

		System.out.println("Player 2 Score: " + player2Score);
		System.out.println("Player 2 Turns: " + player2Turns);

		// Determine the winner
		if (player2Score > player1Score) {
			System.out.println("Player 2 wins!");
		} else {
			System.out.println("Player 1 wins!");
		}
	}
}
