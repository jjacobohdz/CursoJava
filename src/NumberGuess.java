import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        /*
        Write a program that generates a random number n and asks the user to guess it.
        If user enters a number higher than n, print: Enter a smaller number
        If user enters a number smaller than n, print: Enter a higher number
        If user enters the correct number, print: You won! and stop the program
         */
        int n = new Random().nextInt(1, 9999);
        System.out.println(n);

        Scanner scanner = new Scanner(System.in);
        int user = Integer.MIN_VALUE; // simulate a negative infinite
        while (user != n) {
            System.out.print("guess my number: ");
            user = scanner.nextInt();

            if (user > n) {
                System.out.println("enter a smaller number");
            } else if (user < n) {
                System.out.println("enter a bigger number");
            }
        }
        System.out.println("you won!");
    }
}
