package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//逆波兰表达式计算,很遗憾只支持整形计算
public class PolandNotation {
    public static void main(String[] args) {
        //(30+4)*5-6,表达式以空格进行分割
        //String suffixExpression = "30 4 + 5 * 6 - ";
        String suffixExpression1 = "1+((2+3)*4)-5";
//        ArrayList<String> stringList = getStringList(suffixExpression);
//        String calculate = calculate(stringList);
//        System.out.println(calculate);

        List<String> strings = toInfixExpressionList(suffixExpression1);
        System.out.println(strings);

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

    //将中缀表达式转换成对应的list,更方便处理
    public static List<String> toInfixExpressionList(String s) {
        ArrayList<String> list = new ArrayList<String>();  //存放中缀
        int i = 0;//遍历表达式的指针
        String str; //多位数的拼接
        char c; //每遍历到一个字符就放入到c
        do {
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {  //asc||码表大于48小于57分别对应0-9
                list.add("" + c); //说明是运算符号,直接加入就好
                i++; //指针后移
            } else {
                //这里要考虑多位数的问题
                str = "";//每次清空str
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;  //拼接数字
                    i++;
                }
                list.add(str);
            }

        }while (i < s.length());
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
