package recursion;
//八皇后问题
public class EightQueue {
    //定义一个有8个皇后
    int max = 8;
    int count = 0;
    static int judgeCount = 0;
    //存放结果的数组
    int[] array = new int[max];
    public static void main(String[] args) {
        new EightQueue().check(0);
        System.out.println(judgeCount);
    }

    public void check(int n) {
        if(n == max) {
            getResult();
            return;
        }
        for (int i = 0;i < max;i++) {
            //先把皇后n放到改行的第一列
            array[n] = i;
            //判断将皇后n放到第i列时,是否冲突
            if(judge(n)) { //如果不冲突
                //接着放第n + 1个皇后
                check(n + 1);
            }
            //如果冲突,就继续执行array[n] = i,即将此皇后在本行后移一个位置
        }

    }

    //判断当前皇后是否和之前的摆放冲突
    public boolean judge(int n) {
        judgeCount++;
        for (int i = 0;i < n;i++) {
            if(array[i] == array[n] || Math.abs(i - n) == Math.abs(array[i] - array[n])) {  //如果在同一列或同一斜线上则return false
                return false;
            }
        }
        return true;
    }


    public void getResult() {
        count++;
        for (int i = 0;i < array.length;i++) {
            System.out.printf(array[i] + " ");
        }
        System.out.println(" " + count);
    }

}
