package tree.clueingbinarytree;

public class ClueingBinaryTree {
    public static void main(String[] args) {

    }
}

class BinaryT {
    private ClueingNode root;

    public void setRoot(ClueingNode root) {  //只要set一个root节点,就可以进行遍历
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("这树是空的");
        }
    }

    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("这树是空的");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("这树是空的");
        }
    }
    //删除
    public void deleNode(int no) {
        if(this.root != null ) {
            if(this.root.getNo() == no) { //如果要删除的是根节点,整棵树连根拔起
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("这棵树是空的呀");
        }
    }

    //查找
    public ClueingNode preSearch(int no) {
        if(this.root != null) {
            return this.root.preSearch(no);
        } else {
            return null;
        }
    }

    public ClueingNode midSearch(int no) {
        if(this.root != null) {
            return this.root.midSearch(no);
        } else {
            return null;
        }
    }

    public ClueingNode postSearch(int no) {
        if(this.root != null) {
            return this.root.postSearch(no);
        } else {
            return null;
        }
    }

}


class ClueingNode {
    private int no;
    private String name;
    private ClueingNode left; //左指向,默认都是空,所以不需要构造方法
    private ClueingNode right; //右指向

    private int leftType; //= 0 表示指向左子树, = 1,表示指向其前驱
    private int rightType; //= 0 表示指向右子树, = 1,表示指向其后继

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public ClueingNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClueingNode getLeft() {
        return left;
    }

    public void setLeft(ClueingNode left) {
        this.left = left;
    }

    public ClueingNode getRight() {
        return right;
    }

    public void setRight(ClueingNode right) {
        this.right = right;
    }

    @Override
    public String toString() {  //别打左右指向
        return "ClueingNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this); //先输出一个节点,第一次是根节点
        if (this.left != null) {
            this.left.preOrder(); //之后递归
        }
        if (this.right != null) {  //因为递归之后会回溯,所以直接递归右节点就好
            this.right.preOrder();
        }
    }

    //中序遍历
    public void midOrder() {   //一回事,就是换了个顺序而已
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序查找
    public ClueingNode preSearch(int no) {
        System.out.println("前序遍历");
        if (this.no == no) {
            return this;
        }
        ClueingNode resNode = null;

        if (this.left != null) resNode = this.left.preSearch(no);

        if (resNode != null) return resNode;

        if (this.right != null) resNode = this.right.preSearch(no);
        //这块为不为null都得返回了
        return resNode;
    }

    //中序查找
    public ClueingNode midSearch(int no) {

        ClueingNode resNode = null;
        if (this.left != null) resNode = this.left.midSearch(no);

        if (resNode != null) return resNode;

        System.out.println("中序遍历");
        if (this.no == no) return this;

        if (this.right != null) resNode = this.right.midSearch(no);

        return resNode;
    }
    //后序查找
    public ClueingNode postSearch(int no) {

        ClueingNode resNode = null;
        if (this.left != null) resNode = this.left.postSearch(no);

        if (resNode != null) return resNode;

        if (this.right != null) resNode = this.right.postSearch(no);

        if(resNode != null) return resNode;
        System.out.println("后序遍历");
        if (this.no == no) {
            return this;
        }
        return resNode;  //如果都没找到,也只能返回空了
    }

    /**递归删除节点
     * 如果是叶子节点直接删除,否则删除整棵子树
     */
    public void delNode(int no) {
        if(this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if(this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if(this.left != null) {
            this.left.delNode(no);
        }
        if(this.right != null) {
            this.right.delNode(no);
        }
    }


}
