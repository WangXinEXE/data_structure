package linkedlist;

/**
 * 查找单链表中倒数第k个节点(新浪)
 * 写一个方法用来接收head节点和index
 * index表示倒数第index个节点
 * 正向完全遍历后的出的总长度 - index
 * 遍历上述的值的节点个数就ok
 */
public class FindReciprocalNode {
    public static HeroNode findNode(HeroNode head,int index) {
        if(head.next == null) {
            System.out.println("此链表为空");
            return null;
        }
        int length = GetLinkedListNodes.getLength(head); //得到链表的总长度
        if(index > length || index <= 0) {
            System.out.println("不存在的节点");
            return null;
        }
        //第二次遍历到length - index个位置,就是结果.
        HeroNode temp = head.next;
        for (int i = 0;i < length - index;i++) {
            temp = temp.next;
        }
        return temp;
    }
}
