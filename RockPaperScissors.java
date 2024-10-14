import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continuePlaying = true;

        System.out.println("Welcome to Rock, Paper, Scissors!");

        // Game loop
        while (continuePlaying) {
            System.out.println("\nEnter your choice (rock, paper, scissors): ");
            String userChoice = scanner.nextLine().toLowerCase(); // User input
            String[] choices = {"rock", "paper", "scissors"};
            String computerChoice = choices[random.nextInt(3)]; // Random computer choice

            // Validate user input
            if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissors")) {
                System.out.println("Invalid choice! Please choose rock, paper, or scissors.");
                continue; // Restart the loop
            }

            System.out.println("Computer chose: " + computerChoice);

            // Determine the winner
            if (userChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                       (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                       (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }

            // Ask if the user wants to play again
            System.out.println("\nDo you want to play again? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();

            if (response.equals("no")) {
                continuePlaying = false;
                System.out.println("Thanks for playing! Goodbye.");
            }
        }
    }
}