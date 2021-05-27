package tree;

public class ArrBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        new ArrBinaryT(arr).preOrder(0);
    }

}
class ArrBinaryT {
    private int[] arr;

    public ArrBinaryT(int[] arr) {
        this.arr = arr;
    }

    /**
     *
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        if(arr.length == 0 || arr == null) {
            System.out.println("你这树是空的啊");
        }
        //前序遍历先输出父节点
        System.out.println(arr[index]);
        //递归遍历左子树
        if((index * 2 + 1) < arr.length) {  //你得加括号啊,不能这么粗心
            preOrder(index * 2 + 1);  //这块是传坐标,不是传数组
        }
        //右子树
        if((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }
}
