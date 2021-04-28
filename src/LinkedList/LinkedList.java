package LinkedList;

public class LinkedList {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"李逵","黑旋风");

        SingleLinkedList list = new SingleLinkedList();
        list.add(hero1);
        list.add(hero2);
        list.add(hero3);
        list.add(hero4);
        list.list();
    }

}
//定义英雄链表SingleLinkedList,来管理英雄
class SingleLinkedList {
    //先初始化一个头结点,不存放数据
    private HeroNode head = new HeroNode(0,"","");
    //当不考虑插入位置时,添加节点到单向链表
    //1.找到链表的最后一个位置
    //2.将next域指向新插入的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能改变,所以需要一个辅助变量temp来帮助遍历
        HeroNode temp = head;
        //当temp == null 说明找到了尾节点
        while (true) {
            if(temp.next == null) {
                break;
            }
        //如果没有找到,则将temp后移
            temp = temp.next;
        }
        //当退出循环时,说明已经找到了链表的最后.
        temp.next = heroNode;  //指向新的节点.
    }
    //遍历链表的方法
    public void list() {
        if(head.next == null) {
            System.out.println("此链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if(temp == null) {    //这块要是temp.next,就会缺少最后一个数据
                break;
            }
            System.out.println(temp);
            temp = temp.next;

        }
    }
}


//英雄节点的信息,每一个Node代表一个节点
class HeroNode {
    public int no;  //编号
    public String name;
    public String nickname; //昵称
    public HeroNode next; //指向下一个节点
    //构造方法
    public HeroNode (int hNo,String hName,String hNickname) {
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;
    }
    //为了显示方便重写toString


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
