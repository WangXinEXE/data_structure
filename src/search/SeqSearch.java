package search;

public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {6,5,78,14,22,0,66};
        int i = seqSearch(arr, 66);
        System.out.println(i);
    }
    //幼儿园级别,只能找到一个.多个的话用数组存一下
    public static int seqSearch(int[] arr, int i) {
        for (int i1 : arr) {
            if (i1 == i) {
                return i;
            }
        }
        return -1;

    }


}
