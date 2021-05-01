package LinkedList;

public class LinkedList {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"李逵","黑旋风");
        HeroNode hero5 = new HeroNode(4,"wuyifan","wuyifan");

        SingleLinkedList list = new SingleLinkedList();
//        list.add(hero1);
//        list.add(hero2);
//        list.add(hero3);
//        list.add(hero4);


        list.addByOrder(hero4);
        list.addByOrder(hero2);
        list.addByOrder(hero1);
        list.addByOrder(hero3);

          //list.addByOrder(hero5);
        list.list();
        System.out.println("---------------");
        //list.update(hero5);
        //list.deleteNode(4);
        //list.deleteNode(3);
        //list.deleteNode(1);

        list.list();
        System.out.println("一共有" + getLinkedListNodes.getLength(list.getHead()) + "个节点");
    }

}
//定义英雄链表SingleLinkedList,来管理英雄
class SingleLinkedList {
    //先初始化一个头结点,不存放数据
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

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

    public void addByOrder(HeroNode heroNode) {
        //因为是单链表,找到的temp是位于添加前的一个位置,否则插入不了
        HeroNode temp = head;  //辅助变量
        boolean flag = false;  //提示添加的节点是否存在,默认false

        while (true) {
            if(temp.next == null) {
                break;   //说明已经找到链表的最后
            }
            if(temp.next.no > heroNode.no) {  //说明节点位置已经找到
                break;
            }
            if(temp.next.no == heroNode.no) {     //说明位置已经存在
                flag = true;
                break;
            }
            temp = temp.next; //后移,遍历链表
        }
        if(flag) {
            System.out.printf("当前要添加位置已经存在");
        }else {
            heroNode.next = temp.next;   //向当前位置添加数据
            temp.next = heroNode;
        }
    }
    //根据编号修改单链表的节点
    public void update(HeroNode newHeroNode) {
        //先判断是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点,根据no编号来找.
        boolean flag = false;
        HeroNode temp = head;
        while(true) {
            if (temp.no == newHeroNode.no) {  //说明节点找到了
                flag = true;
                break;
            }
            if(temp.next == null) {
                break;
            }
            temp = temp.next;   //后移
        }
        if(flag) {
            temp.nickname = newHeroNode.nickname;
            temp.name = newHeroNode.name;
        }else {
            System.out.println("没有找到节点");
        }
    }
    //删除单链表的节点
    public void deleteNode(int hNo) {
        if(head.next == null) {
            System.out.println("此链表为空,不能够删除了");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if(temp.next == null) {
                System.out.println("没有找到想要删除的编号");
                break;
            }
            if(temp.next.no == hNo) { //说明找到了要删除的编号的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;  //后移
        }
        if(flag) {
            temp.next = temp.next.next;
        }else {
            System.out.println("没有找到想要删除的节点");
        }

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
