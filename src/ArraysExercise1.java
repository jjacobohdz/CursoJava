import java.util.Scanner;

public class ArraysExercise1 {
    public static void main(String[] args) {
        /*
        Create a program that:
        Reads a number n
        Creates an array of size n
        Reads n numbers and stores them in the array
        Prints the sum of the array numbers
        Prints the average of the array numbers
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter a number n: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        // iterating from 0 since arrays are 0 based
        for (int i = 0; i < n; i++) {
            System.out.print("enter a number: ");
            arr[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("sum is " + sum);

        System.out.println("avg is " + (sum / n));

        /*
        Enhance the previous program to:
        Read a number m
        Print whether m exists in the array
        Print the index of m or -1 if it doesn’t exist
         */
        System.out.print("enter a number m: ");
        int m = scanner.nextInt();

        // for vs while
        // repeat while number is not found
        boolean found = false;
        int index = 0;
        int result = -1;
        while (!found && index < arr.length) {
            found = m == arr[index]; // 2 == 1 -> false, 2 == 2 -> true
            if (found) {
                result = index;
            }
            index++;
        }

        System.out.println(result);
    }
}

















