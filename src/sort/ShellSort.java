package sort;

import java.util.Arrays;
//有点意思
public class ShellSort {
    public static void main(String[] args) {
        //int[] arr = {-9,7,13,2,48,-21,3,6,4,54,-66};
        int[] arr = new int[8000000];
        for(int i = 0;i < 8000000;i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        shellSort1(arr);
    }

    //采用逐步推导的方式
    public static void shellSort(int[] arr) {
        int temp = 0;
        long l = System.currentTimeMillis();
        for(int gap = arr.length / 2;gap > 0;gap /= 2) {
            for(int i = gap;i < arr.length;i++) {   //分成arr.length/2组,arr.length/2步长
                for(int j = i - gap;j >= 0;j -= gap) { //每个小组的组内交换
                    if(arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println(Arrays.toString(arr));
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }

    //移位式效率大幅提升
    public static void shellSort1(int[] arr) {
        long l = System.currentTimeMillis();
        for(int gap = arr.length / 2;gap > 0;gap /= 2) {
            for(int i = gap;i < arr.length;i++) {
                int j = i;  //存储下标
                int temp = arr[j];  //存值
                if(arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap]; //往前位移
                        j -= gap;  //位移这么长
                    }
                    arr[j] = temp;
                }
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l + "--------");
        //System.out.println(Arrays.toString(arr));
    }

}
