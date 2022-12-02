import java.util.Scanner;
import java.lang.Math;
public class Number_guess {
    public static void main(String[] args) { 
        int ans = (int) (Math.random() * 100) + 1;
        Scanner sf = new Scanner(System.in);
        System.out.println("Enter number of trials:");
		int n=sf.nextInt();
        boolean right = false;
        System. out.println("System geneerated a number between 1 and 100.You have "+n+" trials to guess the number.");
        while (n > 0) {
            System. out.println("Enter your guess: ");
            int guess = sf.nextInt();
            if (guess == ans) {
                System. out.println("Wohoo!!!You guessed the right number!");
                right=true;
                break;
            }
            
            else if (guess > ans) {
                System.out.println("Your guess is too high.\nYou have " + (n - 1) + " tries left.");
                n--;
            }
            
            else {
                System.out.println("Your guess is too low.\nYou have " + (n - 1) + " tries left.");
                n--;
            }
            
        }
        if (right==false) {
             System.out.println("Sorry!!!Number of attempts are over.");
        }
}
}
