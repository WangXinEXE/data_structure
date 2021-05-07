package linkedlist;

/**
 * 获取单链表中有效节点个数,带头节点的链表需要去掉
 */
public class GetLinkedListNodes {

    public static int getLength(HeroNode head) {
        if(head.next == null) {
            System.out.println("这是一个空链表");
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while(cur != null) {
            length++;
            cur = cur.next;
        }
        //System.out.println("该链表的长度为" + length);
        return length;
    }

}
