package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        //int[] arr = {12,56,7,-9,0,-98,47,6,-17,10,-9,8,7,6,5,4,3,21};
        int[] arr = new int[10];
        for(int i = 0;i < 10;i++) {
            arr[i] = (int)(Math.random() * 100);
        }
        quickSort(arr,0, arr.length - 1);
        //quickSort2(arr,0,arr.length - 1);


    }

    public static void quickSort(int[] arr,int left,int right) {
        int l = left;
        int r = right;
        //这个pivot取中间还是取左右都可以
        int pivot = arr[(left + right) / 2];
        //int pivot = arr[left];
        long p = System.currentTimeMillis();
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
            if(l >= r) {
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
        if(l == r) {
            l++;
            r--;
        }
        if(left < r) {
            quickSort(arr,left,r); //左不动右动
        }
        if(right > l) {
            quickSort(arr,l,right);
        }
        System.out.println(Arrays.toString(arr));
        long p1 = System.currentTimeMillis();
        System.out.println(p1 - p);
    }

    //交换位置的方法
    public static void swap(int[] arr,int l,int r) {
        int temp = 0;
        temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }



}
