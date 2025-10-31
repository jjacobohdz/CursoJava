import java.util.Scanner;

public class MultiplicationTables {
    public static void main(String[] args) {
        // Write a program that reads a number n and prints its multiplication table
        // ie. n=2 -> 2x1=2, 2x2=4… 2x10=20
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a number: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + "x" + i + "=" + (n * i));
        }
    }
}
