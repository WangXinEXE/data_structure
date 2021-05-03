package LinkedList;

import java.util.Stack;

//从尾到头打印单链表(百度)
public class PrintReverseLinkedList {

    public static void printReverseList(HeroNode heroNode) {
        if(heroNode.next == null) {
            System.out.println("空链表,无法打印");
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode temp = heroNode.next;
        while (true) {
            if(temp != null) {        //注意这块判断不能是temp.next, 亲测如果直接用heroNode的话会多出一个空节点.
                stack.add(temp);
                temp = temp.next;
            } else {
                break;
            }
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

}
