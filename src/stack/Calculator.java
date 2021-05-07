package stack;

//实现表达式计算
public class Calculator {
    public static void main(String[] args) {
        String expression = "3+2*6-2";
        //创建两个栈:数栈和符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义所需的变量
        int index = 0; //扫描索引
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int oper = 0;
        char ch = ' ';  //将每次扫描出来的char放入ch中
        //循环判断
        while (true) {
             ch = expression.substring(index, index + 1).charAt(0);
             if(operStack.isOper(ch)) {   //判断是不是操作符
                 if(!operStack.isEmpty()) {  // 是不是空
                     //不为空就做进一步优先级处理
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {   //如果传进来的符号优先级小于等于栈顶的优先级
                        //就需要从数栈中pop两个数,从符号栈中pop一个运算符,进行运算,将结果放入数栈中.然后再将当前的符号放入符号栈.


                    }

                 } else {
                     operStack.pushStack(ch);//是空直接进栈

                 }
             } else {
                 numStack.pushStack(ch);  //是数字直接进栈
             }

        }

    }

}


//需要一个栈类,但是需要扩展几个功能.数字符号判断功能,符号优先级判断功能,运算功能
class ArrayStack2 {
    private int maxSize;//栈的最大容量
    private int[] stack;//用于存放栈的数据
    private int top = -1;//初始化栈顶为-1

    //构造方法
    public ArrayStack2(int arrayMaxSize) {
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

    //返回当前栈顶的值,而不将其移出栈
    public int peek () {
        return stack[top];
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
    //运算符号的优先级返回,由数字决定,越大优先级越高
    public int priority(int oper) {              //Java中int char 是可以混用的
        if(oper == '*' || oper == '/') {
            return 1;
        } else if(oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;    //很遗憾,目前只能支持四个运算符
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }
    //运算功能
    public int cal(int num1,int num2,int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;  //减法注意顺序,后弹出来的数在前
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;  //除法也是一样
                break;
        }
        return res;
    }





}