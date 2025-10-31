import java.util.Scanner;

public class LargestOfThree {
    public static void main(String[] args) {
        // Write a program that reads three numbers and prints the largest among them
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a number a: ");
        int a = scanner.nextInt();
        System.out.print("enter a number b: ");
        int b = scanner.nextInt();
        System.out.print("enter a number c: ");
        int c = scanner.nextInt();

        int largest = 0;
        if (a > b) {
            // a or c can be the largest
            if (b > c) { // 5, 4, 3
                largest = a;
            } else { // 5, 4, 6
                largest = c;
            }
        } else if (b > a) {
            // b or c can the largest
            if (a > c) { // 4, 5, 3
                largest = b;
            } else { // 4, 5, 6
                largest = c;
            }
        }
        // if can be nested
        // else / else if is optional

        System.out.println(largest + " is the largest number");
    }
}
