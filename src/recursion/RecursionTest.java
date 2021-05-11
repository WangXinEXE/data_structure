package recursion;

public class RecursionTest {

    public static void main(String[] args) {
        //test1(6);
        int res = factorial(5);
        System.out.println(res);

    }

    public static void test1(int i) {
        if(i > 2) {
            test1(i - 1);
        }
        System.out.println("i = " + i);
    }

    public static int factorial(int i) {
        if(i == 1) {
            return 1;
        } else {
            return factorial(i - 1) + i;
        }
    }

}

