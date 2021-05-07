package linkedlist;

/**
 * 单链表的反转(腾讯)
 * 定义一个reverseHead = new HeroNode();
 * 遍历原来的链表,每遍历一个就将其放在reverseHead的最前端.
 * 原来链表的head.next = reverseHead.next
 */
public class LinkedListReversal {
    public static void reverseList(HeroNode head) {
        //如果当前链表为空,或者只有一个数据,则直接返回.
        if(head.next == null || head.next.next == null) {
            return;
        }
        //定义辅助变量
        HeroNode cur = head.next;
        //指向当前节点[cur]的下一个节点
        HeroNode next = null;
        //定义reverseHead
        HeroNode reverseHead = new HeroNode(0,"","");

        while(cur != null) {
            next = cur.next;  //存起来
            cur.next = reverseHead.next;//将cur的下一个节点指向链表的最前端
            reverseHead.next = cur; //将cur连接到新的链表上
            cur = next;  //存起来的值赋回来
        }
        head.next = reverseHead.next;  //接头
    }

}
