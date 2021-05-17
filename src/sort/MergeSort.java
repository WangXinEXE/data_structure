package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
//T(n) = O(nlogn)
public class MergeSort {
    public static void main(String[] args) {
        //int[] arr = {15, -20, 3, 7, 48, -6, 12, 77, 9, 56, 4, 0};
        int[] arr = new int[8000000];
        for(int i = 0;i < 8000000;i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        int[] temp = new int[arr.length];  //需要一个额外的temp数组

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = simpleDateFormat.format(date);
        System.out.println("执行前时间" + format1);

        mergeSort(arr,0,arr.length - 1,temp);

        Date date1 = new Date();
        String format = simpleDateFormat.format(date1);
        System.out.println("执行后时间" + format);

        //System.out.println(Arrays.toString(arr));
    }

    /**  合并的方法
     * @param arr   要排序的数组
     * @param left  左数组的第一位下标
     * @param mid   右数组第一位下标的前一个,就是两个数组的中间下标值
     * @param right 右数组的最后一位
     * @param temp  临时存放数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;  //右数组的第一位
        int t = 0; //temp数组的第一位下标
        while (i <= mid && j <= right) {  //这块需要 <= right
            if (arr[i] <= arr[j]) {  //如果左边小于右边
                temp[t] = arr[i];  //将左边的放进temp中
                t++;   //移动坐标
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }
        while (i <= mid) {    //两边肯定有一个先空的,这时就将没空的数组整个放进temp去
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }
        //将temp所有的元素copy到原数组中,因为只有最后一次是整组拷贝,之前所有都不是全部copy
        t = 0; //重置t下标开始拷贝
        int tempLeft = left;
        //System.out.println("tempLeft=" + tempLeft + "right=" + right);
        while (tempLeft <= right) {  //第一次 0   1 ,第二次 2   3,第三次 0   3...最后一次才是0   7
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }
    //分加合并的方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp) {
        if(left < right) {
            int mid = (left + right) / 2;
            //左递归分解
            mergeSort(arr,left,mid,temp);
            //右递归分解
            mergeSort(arr,mid + 1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }







}
