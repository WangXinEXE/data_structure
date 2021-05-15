package sort;

import java.util.Arrays;
//时间复杂度依然是T(n) = O(n^2);
public class ChooseSort {

    public static void main(String[] args) {
        int[] arr = new int[80000];
        for(int i = 0;i < 80000;i++) {
            arr[i] = (int)(Math.random() * 80000);
        }
        long l = System.currentTimeMillis();
        for(int j = 0;j < arr.length - 1;j++) {
            int minIndex = j;
            int min = arr[j];
            for(int i = j + 1;i < arr.length;i++) {
                if(arr[i] > min) {        //一种交换的思想
                    minIndex = i;
                    min = arr[minIndex];
                }
            }
            if(j != minIndex) {
                arr[minIndex] = arr[j];
                arr[j] = min;
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);

    }

}
