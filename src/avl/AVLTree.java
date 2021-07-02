package avl;

public class AVLTree {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        AVLTrees avlTrees = new AVLTrees();
        for (int i : arr) {
            avlTrees.add(new Node(i));
        }
        avlTrees.infixOrder();
        System.out.println("平衡处理前树的高度");
        System.out.println(avlTrees.getRoot().height());
        System.out.println(avlTrees.getRoot().leftHeight());
        System.out.println(avlTrees.getRoot().rightHeight());
    }
}

class AVLTrees {
    private Node root; // 根节点

    public Node getRoot() {
        return root;
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    //返回以node为根节点的二叉树的最小值并删除此节点
    public int deleRightTreeMin(Node node) {
        Node target = node;
        //循环查找左节点最小值
        while (target.left != null) {
            target = target.left;
        }
        deleteNode(target.value);//删除最下节点
        return target.value;
    }

    public void deleteNode(int value) {
        if (root == null) {
            return;
        } else {
            //先找到需要删除的节点
            Node targetNode = search(value);
            if (targetNode == null) {
                return;
            }
            if (root.left == null && root.right == null) { // 如果这棵树只有一个节点
                root = null;
                return;
            }
            Node parent = searchParent(value);
            //删除叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {  //删除两颗子树的节点
                int min = deleRightTreeMin(targetNode.right);
                targetNode.value = min;
                //换个思路左子树找最大的也行
            } else {  //删除有一颗子树的节点
                if (targetNode.left != null) {
                    if (parent != null) {   //处理了根节点没有parent的情况
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

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
    //左旋,绕麻了
    private void leftRotate() {
        //创建新的节点,以当前根节点为基准
        Node newNode = new Node(value);
        //把新的节点的左子树作为当前节点的左子树
        newNode.left = left;
        //把新的节点的右子树设置成当前节点的右子树的左子树
        newNode.right = right.left;
        //把当前节点的值替换成右子节点的值
        value = right.value;
        //把当前节点的右子树设置成当前节点的右子树的右子树
        right = right.right;
        //把当前节点的左子树设置成新的节点
        left = newNode;
    }
    //右旋
    public void rightRotate() {

    }

    //返回以当前节点为根节点的树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1; //本身的节点要算一层,所以要+1
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        } else {
            return left.height();
        }
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        } else {
            return right.height();
        }
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
            } else {
                return null;
            }
        }
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
        //当添加完一个节点后,当(右子树的高度-左子树的高度)>1,开始左旋
        if(rightHeight() - leftHeight() > 1) {
            leftRotate();
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
