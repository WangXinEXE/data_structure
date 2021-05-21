package search;

public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {20, 20, 37, 60, 70, 70, 70, 75, 79, 82, 85, 86, 90, 97, 99, 107, 111, 124, 132, 141, 170, 182, 188};
    }

    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2;i < maxSize;i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     *
     * @param arr
     * @param key 我们需要查找的关键码
     * @return
     */
    public static int fibonacciSearch(int[] arr,int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        int[] f = fib();
        return 0;
    }
}
