package search;

public class DichotomySearch {
    public static void main(String[] args) {
        int[] arr = {20, 37, 60, 70, 75, 79, 82, 85, 86, 90, 97, 99, 107, 111, 124, 132, 141, 170, 182, 188};
        int i = dichotomySearch(arr, 0, arr.length, 7);
        System.out.println(i);

    }

    public static int dichotomySearch(int[] arr, int left, int right, int findVal) {

        if (left > right) {
            return -1;
        }
        int medium = (left + right) / 2;
        if (findVal > arr[medium]) {
            return dichotomySearch(arr, medium + 1, right, findVal);
        } else if (findVal < arr[medium]) {
            return dichotomySearch(arr, left, medium - 1, findVal);
        } else {
            return medium;
        }


    }

}
