package stack;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.pushStack(1);
        stack.pushStack(2);
        stack.pushStack(3);
        stack.pushStack(4);
        stack.pushStack(5);
        stack.popStack();
        stack.list();

    }
}


class ArrayStack {
    private int maxSize;//栈的最大容量
    private int[] stack;//用于存放栈的数据
    private int top = -1;//初始化栈顶为-1

    //构造方法
    public ArrayStack(int arrayMaxSize) {
        this.maxSize = arrayMaxSize;
        stack = new int[this.maxSize];
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈push
    public void pushStack(int value) {
        if (isFull()) {
            System.out.println("栈满了,push不进去了");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈pop
    public int popStack() {
        if (isEmpty()) {
            System.out.println("栈里没货了,出不了了");
        }
        int temp = stack[top];
        top--;
        return temp;
    }

    //遍历 注意需要从栈顶开始遍历
    public void list() {
        if(isEmpty()) {
            throw new RuntimeException("栈空是的");
        }
        for (int i = top;i >= 0;i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
