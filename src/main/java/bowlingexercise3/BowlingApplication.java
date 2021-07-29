package bowlingexercise3;

import java.io.IOException;
import java.util.Scanner;

public class BowlingApplication {

    public static void main(String args[]) throws IOException {

        char press, clear;
        int i = 0;

        while (i < 10) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to 10 Pin Bowling!");
            System.out.println();
            System.out.println("Please enter game score in String format: \n");

            String score = scanner.nextLine();
            Bowling game = new Bowling();
            game.turns(score);

            System.out.println("The total score for this game is: \n");
            System.out.println(game.score());
            System.out.println();
            System.out.println("Press any key to continue, otherwise enter t to terminate: ");

            press = (char) System.in.read();
            System.out.println("You Pressed: " + press);

            do {
                clear = (char) System.in.read();
            } while (clear != '\n');
            System.out.println("\n");

            if (press == 't' | press == 'T') {
                System.out.println("Game Will Now Terminate......Thank You For Playing 10 Pin Bowling");
                break;
            }
        }
    }
}