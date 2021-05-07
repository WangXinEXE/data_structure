package linkedlist;

public class DoubleLinkedList {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1,"宋江1","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义1","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"吴用1","智多星");
        HeroNode2 hero4 = new HeroNode2(4,"李逵1","黑旋风");
        HeroNode2 hero5 = new HeroNode2(5,"奥巴马","圣枪游侠");
        HeroNode2 hero6 = new HeroNode2(6,"菲奥娜","无双剑姬");
        HeroNode2 hero7 = new HeroNode2(7,"李青","盲僧");


        DoubleList doubleList = new DoubleList();
//        doubleList.add(hero1);
//        doubleList.add(hero2);
//        doubleList.add(hero3);
//        doubleList.add(hero4);
        doubleList.addByOrderDouble(hero5);
        doubleList.addByOrderDouble(hero2);
        doubleList.addByOrderDouble(hero1);
        doubleList.addByOrderDouble(hero3);
        doubleList.addByOrderDouble(hero6);
        doubleList.addByOrderDouble(hero7);
        //doubleList.deleteNode(1);
        //doubleList.update(hero5);
        doubleList.list();
    }

}

class DoubleList {
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHeroNode2() {
        return head;
    }

    //遍历双向链表的方法和单向的一样
    public void list() {
        if(head.next == null) {
            System.out.println("此链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if(temp == null) {    //这块要是temp.next,就会缺少最后一个数据
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //双向链表的添加(尾部添加)
    public void add(HeroNode2 heroNode2) {
        //因为head节点不能改变,所以需要一个辅助变量temp来帮助遍历
        HeroNode2 temp = head;
        //当temp == null 说明找到了尾节点
        while (true) {
            if(temp.next == null) {
                break;
            }
            //如果没有找到,则将temp后移
            temp = temp.next;
        }
        //当退出循环时,说明已经找到了链表的最后.
        temp.next = heroNode2;
        heroNode2.pre = temp;   //这里要注意pre指针
    }

    //按顺序添加节点
    public void addByOrderDouble(HeroNode2 heroNode) {
        //因为是双链表,找到的temp就是当前位置
        HeroNode2 temp = head;  //辅助变量
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
            heroNode.next = temp.next;   //向当前位置添加数据,人傻了
            temp.next = heroNode;
            heroNode.pre = temp;
            if(heroNode.next != null) {
                heroNode.next.pre = heroNode;
            }

        }
    }

    //修改方法
    public void update(HeroNode2 newHeroNode) {
        //先判断是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点,根据no编号来找.
        boolean flag = false;
        HeroNode2 temp = head;
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
    //双向链表删除节点
    //对于双向链表可以直接找到要删除的节点就好了,所以对比单向链表,代码有所调整,改动用***标记
    public void deleteNode(int hNo) {
        if(head.next == null) {
            System.out.println("此链表为空,不能够删除了");
            return;
        }
        HeroNode2 temp = head.next; //***
        boolean flag = false;
        while (true) {
            if(temp == null) {   //已经找到链表最后节点的next了
                System.out.println("没有找到想要删除的编号");
                break;
            }
            if(temp.no == hNo) { //说明找到了要删除的编号的前一个节点***
                flag = true;
                break;
            }
            temp = temp.next;  //后移
        }
        if(flag) {
            temp.pre.next = temp.next;//***
            //如果要删除最后一个节点,则下面的代码会空指针,因为找不到.所以要加一个判断
            if(temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("没有找到想要删除的节点");
        }

    }



}

class HeroNode2 {
    public int no;  //编号
    public String name;
    public String nickname; //昵称
    public HeroNode2 next; //指向下一个节点,默认null
    public HeroNode2 pre; // 指向前一个节点,默认null
    //构造方法
    public HeroNode2 (int hNo,String hName,String hNickname) {
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;
    }

    public HeroNode2 () {};
    //为了显示方便重写toString


    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +


                ", pre=" + pre +
                '}';
    }
}
