package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4396,-5,7,20,3,16};
        //第一趟排序最大的就在最后
        for(int i = 0;i < arr.length - 1;i++) {
            int temp;
            if(arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        for (int j = 0;j < arr.length;j++) {
            System.out.println(arr[j]);
        }
    }


}
