package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
//T(n)=O(nlog(r)m)
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {3, 12, 6, 77, 4396, 777, 24, 10, 9, 66};
//        int[] arr = new int[20];
//        for(int i = 0;i < 20;i++) {
//            arr[i] = (int)(Math.random() * 200);
//        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date);
        System.out.println("执行前时间" + format1);

        radixSort(arr);

        Date date1 = new Date();
        String format = simpleDateFormat.format(date1);
        System.out.println("执行后时间" + format);

    }

    public static void radixSort(int[] arr) {  //很明显当前无法处理负数
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();  //求出最大位数

        for (int s = 0, n = 1; s < maxLength; s++, n *= 10) {  //n是取余用的
            //定义一个二维数组来模拟10个桶,以空间来换时间
            int[][] bucket = new int[10][arr.length - 1];  //因为不能保证所有数据的某一位不是相同的,所以数组的大小是arr.length - 1
            //定义一个数组,来存储每次插入桶中的数据个数
            int[] bucketElementCounts = new int[10];

            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10; //取出每个元素个位的值
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;  //为下次来加入桶中的数据做准备
            }
            //按照这个桶的顺序,依次放回原数组
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int i = 0; i < bucketElementCounts[k]; i++) {
                        arr[index] = bucket[k][i];
                        index++;
                    }
                }
                //每轮结束之后都需要将bucketElementCounts[k]重置为0,否则下次回出问题
                bucketElementCounts[k] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
