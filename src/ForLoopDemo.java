public class ForLoopDemo {
    public static void main(String[] args) {
        /*
        for loop has 3 sections:
        - all of them are optional
        - some can be used for a different purpose of their originally intended

        - initialization
        - evaluation
            - evaluates a boolean condition
        - evolution
            - usually an increase or decrease occurs here
         */
        int i = 1;
        for (; i <= 10 ; System.out.println(i++));
    }
}
