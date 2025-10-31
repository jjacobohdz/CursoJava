public class DoWhileDemo {
    public static void main(String[] args) {
        // while -> executes at least zero times
        boolean isRaining = false;
        while (isRaining) {
            System.out.print("is raining!");
        }

        // do while -> executes at least once
        do {
            System.out.print("is raining!");
        } while(isRaining);
    }
}
