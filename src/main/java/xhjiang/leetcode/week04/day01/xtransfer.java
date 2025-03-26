package xhjiang.leetcode.week04.day01;

import java.nio.charset.Charset;
import java.util.Stack;

/**
 * @description: xtransfer
 * @author: xhjiang
 * @date: 2025/3/21 18:42
 * 给定一个字符串表达式，实现一个基本计算器，来计算并返回
 * 3+3*2=9
 */
public class xtransfer {
    public static int cal(String s){
        if (s==null||s.length()==0){
            return 0;
        }
        Stack<Integer> stack=new Stack<>();
        int result=0;
        int num=0;
//        char sign='+';
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            //是数字
            if (Character.isDigit(c)){
                num=c-'0';
            }
            //是符号
            if (!Character.isDigit(c)||i==s.length()-1){
                if (c=='+'){
                    stack.push(num);
                }else if (c=='-'){
                    stack.push(-num);
                }else if (c=='*'){
                    stack.push(stack.pop()*num);
                }else if (c=='/'){
                    stack.push(stack.pop()/num);
                }
//                sign=c;
//                num=0;
            }
        }
        while (!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }


    public static int cal2(String s){
        if (s==null||s.length()==0){
            return 0;
        }
        Stack<Integer> stack=new Stack<>();
        int result=0;
        int num=0;
        char sign='+';
        for (int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            //是数字
            if (Character.isDigit(c)){
                num=c-'0';
            }
            //是符号
            if (!Character.isDigit(c)||i==s.length()-1){
                if (sign=='+'){
                    stack.push(num);
                }else if (sign=='-'){
                    stack.push(-num);
                }else if (sign=='*'){
                    stack.push(stack.pop()*num);
                }else if (sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign=c;
                num=0;
            }
        }
        while (!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
    public static void main(String[] args) {
        String expression="3+3*2";
        System.out.println(cal(expression));
        System.out.println(cal2(expression));
    }
}
