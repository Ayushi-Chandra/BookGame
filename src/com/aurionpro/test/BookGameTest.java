package com.aurionpro.test;

import java.util.Scanner;
import com.aurionpro.model.BookGame;  

public class BookGameTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 1 To Start Game And 0 For Exit: ");
        int choice = getIntInput(scanner, 0, 1);

        if (choice == 1) {
            System.out.print("Enter Player 1 Name: ");
            String player1Name = scanner.nextLine();

            System.out.print("Enter Player 2 Name: ");
            String player2Name = scanner.nextLine();

            BookGame game = new BookGame(player1Name, player2Name);

            System.out.println("Player: " + player1Name);

            int currentPlayer = 1; 
            int roundsPlayed = 0;

            while (!game.isGameOver()) {
                System.out.println("\nEnter 1 To Open Book: ");
                int openBookChoice = getIntInput(scanner, 1);

                if (openBookChoice == 1) {
                    int currentPlayerScore;

                    if (currentPlayer == 1) {
                        int player1Page = game.getPlayer1Page();
                        System.out.println("Page Number: " + player1Page);
                        currentPlayerScore = player1Page % 7;
                    } else {
                        int player2Score = game.getPlayer2Score();
                        System.out.println("Point: " + player2Score);
                        currentPlayerScore = player2Score;
                    }

                    game.updatePlayerScore(currentPlayer, currentPlayerScore); 

                    game.displayScore(currentPlayer);
                    roundsPlayed++;

                    if (currentPlayerScore == 0) {
                        currentPlayer = 3 - currentPlayer;  
                    } else {
                        currentPlayer = 3 - currentPlayer;  
                    }
                } else {
                    System.out.println("Invalid choice!");
                }


            int winner = game.determineWinner();
            String winnerName;

            if (winner == 0) {
                winnerName = "It's a tie!";
            } else {
                winnerName = (winner == 1) ? player1Name : player2Name;
            }

            System.out.println("\n" + winnerName + " wins!");
            System.out.println(player1Name + " scored: " + game.getPlayerScore(1));
            System.out.println(player2Name + " scored: " + game.getPlayerScore(2));
            System.out.println(winnerName + " takes " + roundsPlayed + " Rounds to win the match.");
        }
            } else {
            System.out.println("Exiting the game.");
        }

        scanner.close();
    }

    private static int getIntInput(Scanner scanner, int... validChoices) {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); 

                for (int choice : validChoices) {
                    if (input == choice) {
                        return input;
                    }
                }

                System.out.println("Invalid choice! Please enter a valid choice.");
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    }


