import java.util.Scanner;

public class EvenOrNon {
    public static void main(String[] args) {
        // Write a program that reads a number n and prints whether n is even or odd
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a number: ");
        int n = scanner.nextInt();

        if (n % 2 == 0) {
            System.out.println(n + " is an even number");
        } else {
            System.out.println(n + " is an odd number");
        }
    }
}
