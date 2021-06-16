package binarysorttree;

public class BinarySortTree {
    public static void main(String[] args) {

    }

}
class BinarySortTrees{
    private Node root; // 根节点

    public void add(Node node) {
        if(root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if(root != null) {
            root.infixOrder();
        } else {
            System.out.println("这棵树是空的");
        }
    }
}



class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
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
    //中序遍历
    public void infixOrder() {
        if(this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null) {
            this.right.infixOrder();
        }
    }
}
