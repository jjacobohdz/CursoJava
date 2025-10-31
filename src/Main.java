//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

/**
 * This is the main class of our project.
 */
public class Main {
    /**
     * this is the main method
     * hey after the break!
     * @param args this is the list of arguments passed on the command line
     */
    public static void main(String[] args) {
        // one line comment
        /*
        multiple lines
        comment
         */
        /*
        Data types:
        - Primitives
            - Numeric
                - Integer
                    byte        8 bits
                    short       16 bits
                    int         32 bits
                    long        64 bits

                - Floating Point
                    float       32 bits
                    double      64 bits

            - Boolean
                boolean     (true/false)

            - Character
                char        (characters such as @,a,1,-,...)

        - Objects
            String

        - variables
            - anything you define in your code with a name
        - literals
            - anything you assign to a variable
            - have a default value
                1000    int
                3.14    double

         - Casting
            - explicitly convert one data type into another

          - Type Safety
            - Java is Strongly Typed
            - C is Weakly Typed
                int *age;
                ...
                age = (*int) "hello!"; // runtime is okay
            - Dynamically Typed
                Script languages
                    runtime failures
         */
        byte myByteVar = 127; // 01111111
        int age = (int) 1000000000; // 00000000......0000
        long myDouble = 10000000000l;
        float myFloat = 3.14f;

        String name = "Jacobo";

        // type inference
        var myName = "Jacobo";
        var myAge = 978;
        var myDouble2 = 3.14; // double
    }
}