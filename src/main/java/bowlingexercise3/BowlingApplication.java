package bowlingexercise3;

import java.util.Scanner;

public class BowlingApplication {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to 10 Pin Bowling! " +
                "Please enter game score in String format: \n");

        String score = scanner.nextLine();
        Bowling game = new Bowling();
        game.turns(score);

        System.out.println("The total score for this game is: \n");
        System.out.println();
        System.out.println(game.score());
    }
}