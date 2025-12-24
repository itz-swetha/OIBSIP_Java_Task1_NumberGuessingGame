import javax.swing.JOptionPane;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Random random = new Random();

        int score = 0;
        int round = 1;
        int maxAttempts = 7;

        JOptionPane.showMessageDialog(null,
                "WELCOME TO NUMBER GUESSING GAME\n\n" +
                "Rules:\n" +
                "• Guess a number between 1 and 100\n" +
                "• Maximum attempts: 7\n" +
                "• More points for fewer attempts",
                "Number Guessing Game",
                JOptionPane.INFORMATION_MESSAGE);

        int playAgain = JOptionPane.YES_OPTION;

        while (playAgain == JOptionPane.YES_OPTION) {

            int number = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;

            while (attempts < maxAttempts) {

                String input = JOptionPane.showInputDialog(
                        null,
                        "Round " + round +
                        "\nAttempt " + (attempts + 1) + " of " + maxAttempts +
                        "\nEnter your guess (1–100):",
                        "Guess the Number",
                        JOptionPane.QUESTION_MESSAGE);

                // If user clicks Cancel
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Game Cancelled");
                    System.exit(0);
                }

                int guess = Integer.parseInt(input);
                attempts++;

                if (guess == number) {
                    int points = (maxAttempts - attempts + 1) * 10;
                    score += points;

                    JOptionPane.showMessageDialog(
                            null,
                            "🎉 Correct Guess!\n" +
                            "Attempts used: " + attempts +
                            "\nPoints earned: " + points +
                            "\nTotal Score: " + score,
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    guessed = true;
                    break;
                }
                else if (guess > number) {
                    JOptionPane.showMessageDialog(null, "Too High!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Too Low!");
                }
            }

            if (!guessed) {
                JOptionPane.showMessageDialog(
                        null,
                        "❌ Attempts Over!\nCorrect number was: " + number,
                        "Game Over",
                        JOptionPane.ERROR_MESSAGE);
            }

            playAgain = JOptionPane.showConfirmDialog(
                    null,
                    "Do you want to play another round?\nCurrent Score: " + score,
                    "Play Again",
                    JOptionPane.YES_NO_OPTION);

            round++;
        }

        JOptionPane.showMessageDialog(
                null,
                "GAME ENDED\n\nFinal Score: " + score,
                "Thank You",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
} 

