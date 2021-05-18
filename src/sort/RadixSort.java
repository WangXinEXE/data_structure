package sort;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {3,12,6,77,4396,777,24,10,9,66};

    }

    public static void radixSort(int[] arr) {

        //定义一个二维数组来模拟10个桶,以空间来换时间
        int[][] bucket= new int[10][arr.length - 1];  //因为不能保证所有数据的某一位不是相同的,所以数组的大小是arr.length - 1


    }
}
