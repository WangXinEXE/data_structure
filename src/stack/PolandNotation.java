package stack;

import java.util.ArrayList;
import java.util.Stack;

//逆波兰表达式计算,很遗憾只支持整形计算
public class PolandNotation {
    public static void main(String[] args) {
        //(30+4)*5-6,表达式以空格进行分割
        String suffixExpression = "30 4 + 5 * 6 - ";

        ArrayList<String> stringList = getStringList(suffixExpression);
        String calculate = calculate(stringList);
        System.out.println(calculate);

    }

    //将逆波兰表达式分割放入arraylist中的方法
    public static ArrayList<String> getStringList(String suffixExpression) {
        String[] split = suffixExpression.split(" ");  //以空格分割逆波兰表达式
        ArrayList<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);   //放入数据
        }
        return list;
    }

    public static String calculate(ArrayList<String> ls) {
        Stack<String> result = new Stack<String>();  //存入结果的栈
        for (String l : ls) {
            if(!l.equals("+") && !l.equals("-") && !l.equals("*") && !l.equals("/")) {    //l必须不能等于全部运算符才能进栈,所以是&&而不是||.
                result.add(l);
            } else {
                int pop1 = Integer.parseInt(result.pop());
                int pop2 = Integer.parseInt(result.pop());
                int temp;
                switch (l) {
                    case "+" :
                       temp = pop2 + pop1;
                       result.add(temp + "");
                       break;
                    case "-" :
                        temp = pop2 - pop1;
                        result.add(temp + "");
                        break;
                    case "*" :
                        temp = pop2 * pop1;
                        result.add(temp + "");
                        break;
                    case "/" :
                        temp = pop2 / pop1;
                        result.add(temp + "");
                        break;
                }
            }
        }
        return result.pop();
    }

}
