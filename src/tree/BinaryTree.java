package tree;

public class BinaryTree {
    public static void main(String[] args) {

    }
}

class BinaryT{
    private HeroNode root;

    public void setRoot(HeroNode root) {  //只要set一个root节点,就可以进行遍历
        this.root = root;
    }
    //前序遍历
    public void preOrder() {
        if(this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("这树是空的");
        }
    }

    public void midOrder() {
        if(this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("这树是空的");
        }
    }

    public void postOrder() {
        if(this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("这树是空的");
        }
    }
}

//先创建节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left; //左指向,默认都是空,所以不需要构造方法
    private HeroNode right; //右指向

    public HeroNode(int no, String name) {
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

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {  //别打左右指向
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    //前序遍历
    public void preOrder() {
        System.out.println(this); //先输出一个节点,第一次是根节点
        if(this.left != null) {
            this.left.preOrder(); //之后递归
        }
        if(this.right != null) {  //因为递归之后会回溯,所以直接递归右节点就好
            this.right.preOrder();
        }
    }
    //中序遍历
    public void midOrder() {   //一回事,就是换了个顺序而已
        if(this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if(this.right != null) {
            this.right.midOrder();
        }
    }
    //后序遍历
    public void postOrder() {
        if(this.left != null) {
            this.left.postOrder();
        }
        if(this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);

    }


}
