package binarysorttree;

public class BinarySortTree {
    public static void main(String[] args) {

    }

}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //递归添加节点的方法,满足二叉排序树的要求
    public void add(Node node) {
        if(node == null) {
            return;
        }
        if(node.value < this.value) {
            if(this.left == null) {
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        } else {
            if(this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

    }
}
