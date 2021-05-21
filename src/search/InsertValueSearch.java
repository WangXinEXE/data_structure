package search;

public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = {20, 20, 37, 60, 70, 70, 70, 75, 79, 82, 85, 86, 90, 97, 99, 107, 111, 124, 132, 141, 170, 182, 188};
        int i = insertValueSearch(arr, 0, arr.length - 1, 182);
        System.out.println(i);
    }
    public static int insertValueSearch(int[] arr,int left,int right,int findVal) {
        System.out.println("查找次数");
        if(left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);  //这个公式是核心,很神奇
        int midVal = arr[mid];
        if(findVal > midVal) {
            return insertValueSearch(arr,mid + 1,right,findVal);
        } else if (findVal < midVal) {
            return insertValueSearch(arr,left,mid -1,findVal);
        } else {
            return mid;
        }
    }
}
