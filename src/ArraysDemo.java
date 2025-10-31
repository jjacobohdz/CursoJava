public class ArraysDemo {
    public static void main(String[] args) {
        // in java, arrays are objects
        // creation
        int[] arr = new int[3];
        // accessing through indexes
        arr[0] = 9999;
        // arr[3] = 9; // index 3 is unexisting, only 0, 1, 2
        System.out.println(arr[2]);
        System.out.println(arr.length); // 3

        // inline initilization
        int[] arr2 = {1, 2, 3, 4}; // creates an array of 3 elements
        System.out.println(arr2[2]); // 3
        System.out.println(arr2.length); // 4

        // does 7 exist in arr2? -> no
    }
}
