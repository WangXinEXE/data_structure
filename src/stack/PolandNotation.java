package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//逆波兰表达式计算,很遗憾只支持整形计算
public class PolandNotation {
    public static void main(String[] args) {
        //(30+4)*5-6,表达式以空格进行分割
        //String suffixExpression = "30 4 + 5 * 6 - ";
        String suffixExpression1 = "1+((2+30)*4)-51";
//        ArrayList<String> stringList = getStringList(suffixExpression);
//        String calculate = calculate(stringList);
//        System.out.println(calculate);

        List<String> strings = toInfixExpressionList(suffixExpression1);
        List<String> strings1 = parseSuffixExpression(strings);
        String calculate = calculate(strings1);
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

    public static List<String> parseSuffixExpression(List<String> ls) {

        Stack<String> s1 = new Stack<>();   //运算符栈
        //因为s2在整个转换过程中都没有pop的操作,我们可以用arrayList代替,因为后面害的逆序输出.
        //Stack<Object> s2 = new Stack<>();  //中间结果栈
        ArrayList<String> s2 = new ArrayList<>();

        for (String item : ls) {   //遇到操作数时,压入s2
            if(item.matches("\\d+")) { //正则表达式匹配完整的数字
                s2.add(item);
            } else if (item.equals("(")) {  //匹配到左括号,直接进符号栈
                s1.push(item);
            } else if (item.equals(")")) {  //如果匹配到右括号,则一次弹出si栈顶的运算符,压入s2,直到遇到左括号为止,此时将括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();  //消掉左括号
            } else {
                //当item的优先级小于等于栈顶的优先级时,将s1栈顶的运算符弹出加入到s2中,并再次转到第四步中与新的栈顶进行比较
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);  //将item压回s1继续比较
            }
        }
        //将s1中的运算符依次弹出并加入到s2中,因为加入的是arrayList,所以不需要逆序输出直接遍历即可
        for (int j = 0; j < s1.size(); j++) {
            s2.add(s1.pop());
        }
        return s2;
    }



    public static String calculate(List<String> ls) {
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

class Operation {  //运算符号的优先级

    private static int ADD = 1;//+
    private static int SUB = 1;//-
    private static int MUL = 2;//*
    private static int DIV = 2;//除

    //返回运算符的优先级
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+" :
                result = ADD;
                break;
            case "-" :
                result =  SUB;
            break;
            case "*" :
                result =  MUL;
            break;
            case "/" :
                result =  DIV;
            break;
        }
        return result;
    }


}

