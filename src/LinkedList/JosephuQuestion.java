package LinkedList;

public class JosephuQuestion {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();

        //test
        circleSingleLinkedList.countBoy(1,2,5);

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
    //根据用户的思路,计算小孩子出圈的顺序

    /**
     *
     * @param startNo 从第几号开始数
     * @param countNum 数几次
     * @param nums 一共多少个小孩子
     */
    public void countBoy(int startNo,int countNum,int nums) {
        if(first == null || startNo < 1 || startNo > nums) {
            System.out.println("你这么玩就没意思了");
            return;
        }
        //创建辅助指针,帮助小孩子出圈
        Boy helper = first;
        //让helper指向最后一个小孩
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //注意报数前,先要让两个节点移动startNo-1次
        for (int i = 0;i < startNo - 1;i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //报数时,一直让两个借点移动countNum-1次,直到只剩一个节点
        while (true) {
            if (first == helper) {
                break;
            }
            //让两个借点移动countNum-1次
            for (int i = 0;i < countNum - 1;i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            first= first.getNext(); //出圈
            helper.setNext(first); //移动的不是helper,而是他的next指向.因为next是私有的,所以只能set
        }
        System.out.printf("最后吃鸡的小孩是%d \n",first.getNo());
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
