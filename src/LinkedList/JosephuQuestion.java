package LinkedList;

public class JosephuQuestion {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

    }
}

class CircleSingleLinkedList {
    //先初始化一个boy节点
    private Boy first = new Boy(-1);
    //创建节点容量的方法
    public void addBoy(int nums) {
        if(nums < 1) {
            System.out.println("节点空间大小不符合规范");
            return;
        }
        Boy curBoy = null; //辅助指针
        for(int i = 1;i <= nums;i++) {
            Boy boy = new Boy(i);
            //i=1时自己指向自己
            if(i == 1) {
                first = boy;
                first.setNext(first);//自己指向自己
                curBoy = first;//指向第一个小孩(节点),因为first不能动
            } else {
                curBoy.setNext(boy); //辅助节点指向新添加的节点
                boy.setNext(first); //新节点形成闭环,指向第一个节点
                curBoy = boy;       //辅助节点后移,以备下次添加
            }

        }
    }

    public void showBoy() {
        //先判空
        if(first == null) {
            System.out.println("空的,别闹");
            return;
        }
        //因为first不能动,所以还是需要一个辅助变量
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩子的编号是%d\n",curBoy.getNo());
            if(curBoy.getNext() == first) { //遍历到头了
                break;
            }
            curBoy = curBoy.getNext(); //经典后移
        }
    }
}



//先创建一个boy类,表示一个节点
class Boy {
    private int no;//编号
    private Boy next;//指针,默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
