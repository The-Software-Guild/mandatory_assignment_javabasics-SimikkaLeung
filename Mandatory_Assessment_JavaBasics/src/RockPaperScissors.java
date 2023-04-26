// Author: Simikka Fung Sim Leung
// This program allows a user to play the Rock, Paper, Scissors game with a computer.
// The flowchart of this program can be found at https://drive.google.com/file/d/18u8vHzWT0iCcMGKvB_SmKzugXaBuGBDV/view?usp=sharing
/*
 * The rules of the game are as follows:

 * Each player chooses Rock, Paper, or Scissors.
 * If both players choose the same thing, the round is a tie.
 * Otherwise:
 * Paper wraps Rock to win
 * Scissors cut Paper to win
 * Rock breaks Scissors to win
 */
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Display a greeting message
		System.out.println(".oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.");
		System.out.println("           Welcome to the Rock-Paper-Scissors game!          ");
		System.out.println("              You will play against a computer!              ");
		System.out.println("            The rules of the game are as follows:            ");
		System.out.println();
		System.out.println("        Each player chooses Rock, Paper, or Scissors.        ");
		System.out.println("              You will play against a computer!              ");
		System.out.println("  If both players choose the same thing, the round is a tie. ");
		System.out.println("                          Otherwise:                         ");		
		System.out.println("                   Paper wraps Rock to win.                  ");
		System.out.println("                  Scissors cut Paper to win.                 ");
		System.out.println("                 Rock breaks Scissors to win.                ");
		System.out.println("                   Good luck and have fun!                   ");
		System.out.println(".oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.");
		System.out.println();
		
		// Declare variables.
		Scanner keyboard = new Scanner(System.in);	// A Scanner object that accepts inputs from the user
		Random randomGenerator = new Random();	//	To help generate random choices of hand signals of the computer player
		
		// The program will display the hand signals of both players in text in each round.
		String[] handSignal = new String[3];	// There are 3 hand signals.
		handSignal[0] = "Rock";
		handSignal[1] = "Paper";
		handSignal[2] = "Scissors";
		String responsePlayAgain;	// This variable determines if the program will play the game again.
		
		do {
			
			// Initialize the following variables inside this outermost do-while loop because the user may play the game again.
			int numOfRounds = 0;	// The number of rounds remaining
			int numOfTies = 0;		// The number of rounds where the two players tied			
			int numOfUserWins = 0;		// The number of rounds where the user wins
			int numOfComputerWins = 0;		// The number of rounds where the computer wins
			responsePlayAgain = "";			// Initialize the variable
			
		
			boolean toCheckRange = true;		// If the input is not an integer, the program does not need to check if the value is within the range.
			// Ask the user for the number of rounds they want to play.
			// I used a do-while loop because the body needs to be executed at least once.
			do {
				// Prompt for an input.
				System.out.println("Please enter the number of rounds you want to play. The number must be in the range from 1 to 10.");
				String stringNumOfRounds = keyboard.nextLine();
				
				// Check if the input is valid.
				try {
					numOfRounds = Integer.parseInt(stringNumOfRounds);
				} catch (NumberFormatException ex) {
					System.out.println("Invalid input! Please enter an integer in the range from 1 to 10.");
					toCheckRange = false;
				}
				
				if (toCheckRange && (numOfRounds < 1 || numOfRounds > 10)) {
					System.out.println("Invalid input! Please enter an integer in the range from 1 to 10.");
				}
				
			} while (numOfRounds < 1 || numOfRounds > 10);
			
			toCheckRange = true;	// Re-initialize the value of this boolean variable.
			
			// Ask the user for the hand signals in each round.
			// I used a do-while loop because the body needs to be executed at least once.
			do {				
				int userHandSignal = 0; 	// Declare the variable that will hold the user's choice of hand signal.
				int computerHandSignal = 0; 	// Declare the variable that will hold the computer's choice of hand signal.
				do {
					// Prompt for an input.
					System.out.println("Please enter the corresponding number of the hand signal that you want. 1 = Rock, 2 = Paper, 3 = Scissors");
					String stringUserHandSignal = keyboard.nextLine();
					
					// Check if the input is valid.
					try {
						userHandSignal = Integer.parseInt(stringUserHandSignal);
					} catch (NumberFormatException ex) {
						System.out.println("Invalid input! Please enter an integer in the range from 1 to 3.");
						toCheckRange = false;
					}
					
					if (toCheckRange && (userHandSignal < 1 || userHandSignal > 3)) {
						System.out.println("Invalid input! Please enter an integer in the range from 1 to 3.");
					}

				} while (userHandSignal < 1 || userHandSignal > 3);
									
				userHandSignal = userHandSignal-1;	// userHandSignals-1 because the index of the handSingal array starts from 0 instead of 1.
				computerHandSignal = randomGenerator.nextInt(3);	// The computer selects a hand signal randomly. The value is 0-2.
				
				// Display the hand signals of both players.
				System.out.println("You have chosen the " + handSignal[userHandSignal] + " and the computer has chosen the " + handSignal[computerHandSignal] + ".");		
				
				// Determine and display the result of the current round.
				if (userHandSignal == computerHandSignal) {
					System.out.println("You and the computer are tied!");
					numOfTies++;
				} else if ( (userHandSignal == 1 && computerHandSignal == 0) || (userHandSignal == 2 && computerHandSignal == 1) || (userHandSignal == 0 && computerHandSignal == 2)) {
					System.out.println("You win!");
					numOfUserWins++;				
				} else {
					System.out.println("The computer wins!");
					numOfComputerWins++;	
				}
				numOfRounds--;	//	Decrement the number of rounds remaining by 1.
			} while (numOfRounds >=1);

			// After playing all the rounds, display the final result.			
			System.out.println();
			System.out.println("Number of Ties: " + numOfTies + " Number of User Wins: " + numOfUserWins + " Number of Computer Wins: " + numOfComputerWins);
			
			// Determine and display the winner.
			if (numOfUserWins == numOfComputerWins) {
				System.out.println("No one wins the game. You two tie!");
			} else if (numOfUserWins > numOfComputerWins) {
				System.out.println("Congratulations! You win!");
			} else {
				System.out.println("Too bad! You lose!");
			}
					
			System.out.println();
			
			// Ask the user if they want to restart the game.						
			// I used a do-while loop because the body needs to be executed at least once.
			do {
				System.out.println("Do you want to play again? Yes / No");
				responsePlayAgain = keyboard.next();	// responsePlayAgain will include the new line character if we use keyboard.nextLine();
				keyboard.nextLine();	// Discard the empty line;
				responsePlayAgain = responsePlayAgain.toLowerCase();	// Turns all alphabetical letters into lower case.
				
				// Check if the input is valid.
				if (!responsePlayAgain.equals("no") && !responsePlayAgain.equals("yes")) {
					System.out.println("Invalid input! Please enter only yes or no.");
				}
				
			} while (!responsePlayAgain.equals("no") && !responsePlayAgain.equals("yes"));
			
			System.out.println();
			
		} while (responsePlayAgain.equals("yes"));	// Start the game again if the response is yes.
		
		// Display the goodbye message.
		System.out.println("Thanks for playing!");
		
		keyboard.close();		// Close the Scanner object to prevent any resource leak.
	}

}
