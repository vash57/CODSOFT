/*
* PROJECT: NUMBER GAME
* Internship:CODSOFT
* Task: 1
* Description: 
* This program is a simple Number Guessing Game.
* The Computer generates a random number,and the user
* tries to guess it within a limited number of attempts

* Author: DEV KUMAR CHAUBEY
* Date : 26 Aug 2025
*/
import java.util.Random;
import java.util.Scanner;

public class TASK_1_NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("********* Number Game *******");
        System.out.println("Defeat Me by Giving a no guess between 1 to 100");
        System.out.println("And if you not interest then type -1 )");

        int target = 1 + rand.nextInt(100); // To Generate the Random no
        int attempts = 0;

        // For Hints Part for Player
        int low = 1;
        int high = 100;

        while (true) {
            System.out.print("Enter Your Guess Number ");
            int guess = sc.nextInt(); // Accept the Value from the Player

            if (guess == -1) { // if you not intereset to play then exit
                System.out.println(" So You Quit the Game Btw that Random no is  " + target);
                break;
            }

            attempts++;

            if (guess == target) {
                System.out.println("Coreect ");
                System.out.println("You " + attempts + " attempts me guess kiya.");
                break;
            } else if (guess < target) {
                System.out.println("Too low! Try Big Number.");
                low = guess + 1; // For Hints part if you guess lower value
            } else {
                System.out.println("Too high! Try Lower Number");
                high = guess - 1; // For HInts part if you guess max value
            }

            // For More Easy to Guess
            System.out.println("Hint: Number " + low + " aur " + high + " in between");
        }

        sc.close();
        System.out.println("Game Over Thank Youuuuuuuuuu Guyssss.....");
    }

}



