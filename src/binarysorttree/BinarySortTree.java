package binarysorttree;

public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTrees binarySortTrees = new BinarySortTrees();
        for (int i : arr) {
            binarySortTrees.add(new Node(i));
        }
        binarySortTrees.infixOrder();
    }

}

class BinarySortTrees {
    private Node root; // 根节点

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
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

    //根据value找到要删除的节点
    public Node search(int value) {
        if (value == this.value) {
            return this;
        }
        if (value < this.value) {  //说明需要去左子树寻找
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除节点的父节点
    public Node searchParent(int value) {
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果当前value的值小于当前节点的值,且当前节点的左子节点不为空,则递归查找
            if ((value < this.value) && (this.left != null)) {
                return this.left.searchParent(value);
            } else if ((value >= this.value) && (this.right != null)) {
                return this.right.searchParent(value);
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //递归添加节点的方法,满足二叉排序树的要求
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
