package search;

import java.util.ArrayList;
import java.util.Arrays;

public class DichotomySearch {
    public static void main(String[] args) {
        int[] arr = {20, 20, 37, 60, 70, 70, 70, 75, 79, 82, 85, 86, 90, 97, 99, 107, 111, 124, 132, 141, 170, 182, 188};
        int i = dichotomySearch(arr, 0, arr.length - 1, 188);
        //System.out.println(i);

        ArrayList<Integer> list = newDichotomySearch(arr, 0, arr.length, 20);
        for (Integer integer : list) {
            System.out.println(integer);
        }

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

    //处理如果存在多个想要查询的数据的情况
    public static ArrayList<Integer> newDichotomySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<>();
        }
        int medium = (left + right) / 2;
        if (findVal > arr[medium]) {
            return newDichotomySearch(arr, medium + 1, right, findVal);
        } else if (findVal < arr[medium]) {
            return newDichotomySearch(arr, left, medium - 1, findVal);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            int temp = medium;
            while (true) {   //左扫描
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp--;
            }
            //注意中间元素先放进去
            temp = medium + 1;
            while (true) {   //右扫描
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                list.add(temp);
                temp++;
            }
            return list;
        }


    }


}
