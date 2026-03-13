package Activities.RockPaperScissors;

import java.util.Random;
import java.util.Scanner;


class InvalidChoiceException extends Exception {
    public InvalidChoiceException(String message) {
        super(message);
    }
}

public class RockPaperScissors {

    
    public static void validateChoice(String choice) throws InvalidChoiceException {
        if (!(choice.equals("rock") || choice.equals("paper") || choice.equals("scissors"))) {
            throw new InvalidChoiceException("Invalid choice! Enter rock, paper, or scissors.");
        }
    }


    public static String getComputerChoice() {
        Random random = new Random();
        int value = random.nextInt(3);

        if (value == 0) {
            return "rock";
        } else if (value == 1) {
            return "paper";
        } else {
            return "scissors";
        }
    }

   
    public static String findWinner(String user, String computer) {

        if (user.equals(computer)) {
            return "Draw!";
        }

        if (user.equals("rock") && computer.equals("scissors") ||
            user.equals("paper") && computer.equals("rock") ||
            user.equals("scissors") && computer.equals("paper")) {

            return "You Win!";
        }

        return "Computer Wins!";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean play = true;

        System.out.println("===== Rock Paper Scissors Game =====");

        while (play) {

            try {

                System.out.print("\nEnter your choice (rock/paper/scissors): ");
                String userChoice = scanner.nextLine().toLowerCase().trim();

        
                validateChoice(userChoice);

                
                String computerChoice = getComputerChoice();

                System.out.println("Your choice: " + userChoice);
                System.out.println("Computer choice: " + computerChoice);

           
                String result = findWinner(userChoice, computerChoice);

                System.out.println("Result: " + result);

            } catch (InvalidChoiceException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {

                System.out.println("Unexpected error occurred.");

            }

         
            System.out.print("\nPlay again? (yes/no): ");
            String again = scanner.nextLine().toLowerCase();

            if (!again.equals("yes")) {
                play = false;
            }
        }

        System.out.println("\nThanks for playing!");
        scanner.close();
    }
}