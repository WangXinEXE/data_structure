package tree;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 9, 6, 7, 7, 12, 1};

    }

    public static void heapSort(int[] arr) {
        System.out.println("开始堆排序");
    }

    /**
     * @param arr    数组
     * @param i      叶子节点的索引
     * @param length 数组的长度
     */
    public static void adjust(int[] arr, int i, int length) {
        int temp = arr[i];

        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if(k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if(arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;

    }

}
