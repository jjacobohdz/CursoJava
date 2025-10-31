import java.util.Scanner;

public class PositiveNegativeOrZero {
    public static void main(String[] args) {
        // Write a program that reads a number and prints whether is positive, negative or zero
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a number: ");
        int n = scanner.nextInt();
        if (n > 0) {
            System.out.println(n + " is a positive number");
        } else if (n < 0) {
            System.out.println(n + " is a negative number");
        } else  {
            // n is always 0 here
            System.out.println(n + " is zero");
        }
    }
}
