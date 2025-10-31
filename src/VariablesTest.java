import java.util.Scanner;

public class VariablesTest {
    public static void main(String[] args) {
        /*
        1. Declare a variable and assign your name to it
        2. Create a variable and assign your age to it
        3. Create a variable and assign your height in meters
        4. Create a constants and assign the value of PI
        5. Create a variable and assign whether you like programming or not
        6. Declare a constant with your email
        7. Declare a variable and assign your first last name initial
         */
        String name = "Francisco Javier Garcia Valdivia";
        int age = 20;
        double height = 1.63;
        final double pi = 3.14;
        // pi = 2.14; // do not try to compile this at home!
        boolean likesProgramming = true;
        final String email = "hugo@gmail.com";
        char initial = 'M';

        // standard output
        System.out.println("Hello World!");
        System.out.printf("pi value is %f and age value is %d%n", pi, age);

        // standard input
        Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter your name: ");
        // String name2 = scanner.nextLine();
        // System.out.println("Hello " + name2);

        // standard error
        // System.err.println("an error occurred!");

        // operators
        System.out.println(5 % 2); // 1

        int x = 1;
        // ++ and -- suffix & prefix
        // suffix (increasing occurs after the current instruction)
        System.out.println(x++); // 1
        System.out.println(x); // 2
        // prefix (increasing occurs immediately)
        System.out.println(++x); // 3

        // | &      ||  &&
        // ~ 2 complement
        byte b = 1; // 00000001 -> 11111110
        System.out.println(~b); // -2
    }
}
