//package LinkedList;
//
////合并两个有序的单链表,合并之后依旧是有序的 (递归方式)
//public class MergeLinkedList {
//
//    public static SingleLinkedList mergeList(SingleLinkedList l1,SingleLinkedList l2 ) {
//
//        if(l1.next == null && l2.next == null) {
//            return null;
//        }
//        if(l1.next == null && l2.next != null) {
//            return l2;
//        }
//        if(l1.next != null && l2.next == null) {
//            return l1;
//        }
//        SingleLinkedList temp = null;
//        if(l1.no > l2.no) {
//            temp = new SingleLinkedList(l1.no,l1.name,l1.nickname,l1.getHead());
//            temp.next = mergeList(l1,l2);
//
//        }
//        if(l1.no < l2.no) {
//            temp = new HeroNode(l2.no,l2.name,l2.nickname);
//            temp.next = mergeList(l1,l2.next);
//        }
//        return temp;
//    }
//}
