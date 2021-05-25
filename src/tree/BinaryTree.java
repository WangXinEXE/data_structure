package tree;

public class BinaryTree {
    public static void main(String[] args) {
        BinaryT binaryT = new BinaryT();

        HeroNode root = new HeroNode(1, "菲奥娜");
        HeroNode heroNode1 = new HeroNode(2, "卢锡安");
        HeroNode heroNode2 = new HeroNode(3, "兰博");
        HeroNode heroNode3 = new HeroNode(4, "大司马");
        HeroNode heroNode4 = new HeroNode(5, "韩金龙");
        binaryT.setRoot(root);
        root.setLeft(heroNode1);
        root.setRight(heroNode2);
        heroNode2.setRight(heroNode3);
        heroNode2.setLeft(heroNode4);
//        binaryT.preOrder(); //12354
//        System.out.println("----");
//        binaryT.midOrder(); //21534
//        System.out.println("----");
//        binaryT.postOrder();//25431
        HeroNode heroNode = binaryT.preSearch(5);
        System.out.println(heroNode);
    }
}

class BinaryT {
    private HeroNode root;

    public void setRoot(HeroNode root) {  //只要set一个root节点,就可以进行遍历
        this.root = root;
    }

    //前序遍历
    public void preOrder(int i) {
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

    //查找
    public HeroNode preSearch(int no) {
        if(this.root != null) {
            return this.root.preSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode midSearch(int no) {
        if(this.root != null) {
            return this.root.midSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode postSearch(int no) {
        if(this.root != null) {
            return this.root.postSearch(no);
        } else {
            return null;
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
    public HeroNode preSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;

        if (this.left != null) resNode = this.left.preSearch(no);

        if (resNode != null) return resNode;

        if (this.right != null) resNode = this.right.preSearch(no);
        //这块为不为null都得返回了
        return resNode;
    }

    //中序查找
    public HeroNode midSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) resNode = this.left.midSearch(no);

        if (resNode != null) return resNode;

        if (this.no == no) return this;

        if (this.right != null) resNode = this.right.midSearch(no);

        return resNode;
    }
    //后序查找
    public HeroNode postSearch(int no) {
        HeroNode resNode = null;
        if (this.left != null) resNode = this.left.postSearch(no);

        if (resNode != null) return resNode;

        if (this.right != null) resNode = this.right.postSearch(no);

        if(resNode != null) return resNode;

        if (this.no == no) {
            return this;
        }
        return resNode;  //如果都没找到,也只能返回空了
    }



}
