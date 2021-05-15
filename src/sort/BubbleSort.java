package sort;

import java.util.Arrays;
//他的时间复杂度是O(n^2)双重for
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {4396,-5,7,20,3,16};
        int[] arr = new int[80000];
        for(int i = 0;i < 80000;i++) {
            arr[i] = (int)(Math.random() * 80000);
        }
        //第一趟排序最大的就在最后
        int temp;
        boolean flag = false; //检测是否发生交换
        long l = System.currentTimeMillis();
        for(int k = 0;k < arr.length - 1;k++) {    //总共循环arr.length - 1次
            for(int i = 0;i < arr.length - k - 1;i++) {  //每次循环一遍之后,交换的次数都减一
                if(arr[i] > arr[i + 1]) {
                    flag = true; //如果进来了,则代表发生交换
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            if (!flag) {
                break;    // 如果等于false,就说明没有发生交换
            } else {
                flag = false; //这块一定要重置flag,否则判断无效的
            }
//            System.out.println("第" + (k + 1) + "次排序后的数组");
//            System.out.println(Arrays.toString(arr));
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);

    }


}
