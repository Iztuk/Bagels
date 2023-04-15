import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("""
                I am thinking of a 3 digit number. Try to guess what it is.
                Here are some clues:
                When I say:     That means:
                    Pico            One digit is correct but in the wrong position.
                    Fermi           One digit is correct and in the right position.
                    Bagels          No digit is correct.
                
                I have thought of a number.
                You have 10 guesses to get it.
                """);

        boolean playAgain = true;

        while (playAgain) {
            // Generate a random 3-digit number
            int secretNum = (int)(Math.random() * 999);
            int numGuesses = 1;
            boolean hasWon = false;

            while (numGuesses <= 10) {
                // Get the user's guess
                System.out.print("Guess #" + numGuesses + ": ");
                int guess = input.nextInt();

                // Check if the guess is correct
                if (guess == secretNum) {
                    System.out.println("You got it!");
                    hasWon = true;
                    break;
                } else {
                    // If the guess is not correct, provide clues
                    String guessStr = Integer.toString(guess);
                    String secretStr = Integer.toString(secretNum);
                    String clues = "";
                    for (int i = 0; i < 3; i++) {
                        if (guessStr.charAt(i) == secretStr.charAt(i)) {
                            clues += "Fermi ";
                        } else if (secretStr.contains(Character.toString(guessStr.charAt(i)))) {
                            clues += "Pico ";
                        } else {
                            clues += "Bagels ";
                        }
                    }
                    System.out.println(clues);
                    numGuesses++;
                }
            }

            if (!hasWon) {
                System.out.println("Sorry, you ran out of guesses. The number was " + secretNum);
            }

            // Ask if the user wants to play again
            System.out.print("Do you want to play again? (Yes or No) ");
            String playAgainStr = input.next();
            if (playAgainStr.equalsIgnoreCase("No")) {
                playAgain = false;
            }
        }
        System.out.println("Thanks for playing!");
    }
}
