package startup_projects;

import java.util.*;

/* 
 * 1. Constructor to generate the random number
 * 2. takeUserInput() to take a user input 
 * 3. isCorrectNumber() to detect whether the number entered by the user is correct or not
 * 4. getter and setter for noOfGuesses
 */

import java.util.Scanner;
import java.util.Random;

public class P3_Guess_The_Number {
	public static void instructions() {
		System.out.println("\t\t***** Rules *****");
		System.out.println("  Please read the instructions carefully!!");
		System.out.println("\t1. You have to guess a number from 1 to 100.");
		System.out.println("\t2. You will be given 5 chances to guess.");
		System.out.println("\t3. If you failed to guess the number within the given limit you loose the round.");
		System.out.println("\t4. There are overall 5 rounds. To win the game you have to win at least 3 rounds.");
		System.out.println("\t5. Throughout the game you will be continuously given the hints.");
		System.out.println("\t6. If you win a round you earn 5 points else lose 1 point.");
		System.out.println("\t7. The final score (out of 25) will be considered.");
		System.out.println("\t8. Once started you can't quit the game in between.");
	}
	public static int guess() {
		int user_guess,comp_guess,guessed = 0;
		int K = 5,chance,count = 0;
		int score = 0,round;
		boolean guess = true;
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		
		// 5 rounds of the game
		for (round = 1;round <=5;round++) {
			System.out.println("\n\t****** Round"+(round)+" ******\n");
			comp_guess = rand.nextInt(1,101);
			// 5 chances for a round
			for (chance = 1;chance<=K;chance++) {
				System.out.println("\n****** Chance"+(chance)+" ******\n");
				System.out.print("Guess the  number:");
				user_guess = sc.nextInt();
				
				if(user_guess<1 || user_guess>100) {
					System.out.println("Number guessed out of given range!\nPlease try again\n");
					guess();
				}
				else {
					if (user_guess>comp_guess) {
						if(user_guess-comp_guess>20) {
							System.out.println("Guessed number is too much greater than computer number.\n");
							guessed++;						
							System.out.println((5-guessed) + " guesses left");
						}
						else if(user_guess-comp_guess>10) {
							System.out.println("Guessed number is greater than computer number.\n");
							guessed++;
							System.out.println((5-guessed) + " guesses left");
						}
						else {
							System.out.println("Guessed number is greater than computer number. You are close to the number.\n");
							guessed++;
							System.out.println((5-guessed) + " guesses left");
							}
					}
					else if (comp_guess>user_guess) {
						if(comp_guess-user_guess>20) {
							System.out.println("Guessed number is too much lower than computer number.\n");
							guessed++;
							System.out.println((5-guessed) + " guesses left");
						}
						else if(comp_guess-user_guess>10) {
							System.out.println("Guessed number is lower than computer number.\n");
							guessed++;
							System.out.println((5-guessed) + " guesses left");
						}
						else {
							System.out.println("Guessed number is lower than computer number. You are close to the number.\n");
							guessed++;
							System.out.println((5-guessed) + " guesses left");
							}
					}
					else {
						System.out.println("Congrats! You guessed the number!! :)");
						System.out.println("You guessed it on  " + (guessed + 1) + " guess.\n");
						break;
						}
				}
				if (chance == K){
					System.out.println("Oh!");
					System.out.println("You have exhausted the limit.");
					System.out.println("The number was " + comp_guess);
					score--;
					guess = false;
					}
				
			}
			//increasing the score and count if user guessed the number correctly
			if(guess) {
				score += 5; 
				count++;
			}
			
			chance = 0;
			guessed = 0;
			guess = true;
		}
		if(count<3) {
			System.out.println("You lose the game because you only won " + count + " rounds.");
		}
		else {
			System.out.println("Congrats!! You won the game.");
			System.out.println("You guessed " + count + " numbers.");
			}
		count = 0;
		
		
		return score;
		
	}

	public static void main(String[] args) {
		instructions();
		int myScore;
		System.out.println("\nGet ready!!");
		myScore = guess();
		System.out.println("Your overall score is " + myScore + " out of 25."); 
		int round = 0;
		do {
			System.out.println("\n****** Round"+(round+1)+" ******");
			round += 1;
			guess();
		}while(round!=5);
	}
}
