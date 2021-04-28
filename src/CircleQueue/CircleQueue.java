package CircleQueue;

public class CircleQueue {
    public static void main(String[] args) {

    }

}

class Queue {
    private int maxSize; //最大容量
    private int front;   //队列头
    private int rear;    //队列尾,预留出一块空间用来约定.所以它指向末尾数据的后一个位置.
    private int[] arr;   //用于存放数据,模拟队列

    //队列的构造方法
    public Queue(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }
    //判断队列是否已满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }
    //向队列添加数据
    public void addQueue(int n) {
        if(isFull()) {
            throw new RuntimeException("队列已满,不能加入咯");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize; //rear后移,防止下标越界,所以取模.
    }
    //获取队列的数据,出队列,将front后移.
    public int getQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空,不能取出数据");
        }
        int temp = arr[front]; //先用一个临时变量存储起来
        front = (front + 1) % maxSize; //后移
        return temp;
    }
    //显示队列的所有数据
    public void showAllQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空,没有数据展示");
        }
        for (int i = front; i < front + (rear - front + maxSize) % maxSize;i++) {
            System.out.println(i % maxSize + "" + arr[i % maxSize]);
        }
    }
    //显示队列的头数据
    public int getFront() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有数据");
        }
        return arr[front];
    }
    //显示队列的尾数据
    public int lastQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有数据");
        }
        return arr[rear - 1];
    }






}
