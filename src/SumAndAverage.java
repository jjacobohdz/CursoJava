import java.util.Scanner;

public class SumAndAverage {
    public static void main(String[] args) {
        // Write a program that reads a number n and prints the sum and average of 1 to n
        // ie. n=3, sum=6, avg=2.0
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a number: ");
        int n = scanner.nextInt();

        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        double avg = sum / n;
        System.out.println("the sum is: " + sum);
        System.out.println("the avg is: " + avg);
    }
}
