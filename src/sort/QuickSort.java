package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
//时间复杂度 T(n)=O(nlogn)
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {12,56,7,-9,0,-98,47,6,-17,10,-9,8,7,6,5,4,3,21};
//        int[] arr = new int[8000000];
//        for(int i = 0;i < 8000000;i++) {
//            arr[i] = (int)(Math.random() * 8000000);
//        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date);
        System.out.println("执行前时间" + format1);

        quickSort(arr,0, arr.length - 1);

        Date date1 = new Date();
        String format = simpleDateFormat.format(date1);
        System.out.println("执行后时间" + format);

    }

    public static void quickSort(int[] arr,int left,int right) {
        int l = left;
        int r = right;
        //这个pivot取中间还是取左右都可以
        int pivot = arr[(left + right) / 2];
        //int pivot = arr[left];
        //long p = System.currentTimeMillis();
        while(l < r) {  //如果l<r说明还能移动
            //如果小于,说明没有找到,l继续右移
            while(arr[l] < pivot) {
                l += 1;
            }
            //同理,r左移
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果相等,就说明两个坐标相遇了,此时应该结束循环
            if(l == r) {   //这块注意手写的时候给忘了
                break;
            }
            //lr交换位置
            swap(arr,l,r);

            if(arr[l] == pivot) {
                //System.out.println("----");
                r--;              //因为不能让l移动到pivot的右边
            }
            if(arr[r] == pivot) {
                l++;
            }

        }
        if(l <= r) {
            l++;
            r--;
        }
        if(left < r) { //这块注意手写的时候给忘了
            quickSort(arr,left,r); //左不动右动
        }
        if(right > l) {
            quickSort(arr,l,right);
        }
        System.out.println(Arrays.toString(arr));
        //long p1 = System.currentTimeMillis();
        //System.out.println(p1 - p);
    }

    //交换位置的方法
    public static void swap(int[] arr,int l,int r) {
        int temp = 0;
        temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }



}
