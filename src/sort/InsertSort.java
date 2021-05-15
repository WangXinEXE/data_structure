package sort;

import java.util.Arrays;
//T(n) = O(n^(1-2))
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {7,3,98,-4,101,56};
        insertSort(arr);
    }
    public static void insertSort(int[] arr) {
        for(int i = 1;i < arr.length ;i++) {
            //定义待插入的数
            int insertValue = arr[i];
            //待插入数的前一个坐标
            int insertIndex = i - 1;
            //保证不会越界                   //如果小于,说明要往前移动
            while (insertIndex  >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex]; //待插入数的前一个数位置后移
                insertIndex--;
            }
            if(insertIndex + 1 != i) {   //加个判断,如果位置没有发生变化则不需要再赋值
                arr[insertIndex + 1] = insertValue;  //这次才是将待插入的数放入对的位置
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
