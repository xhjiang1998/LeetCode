package xhjiang.leetcode.day01;

import java.util.HashMap;
import java.util.Map;

public class exercise13 {
    Map<Character,Integer> symbolValue=new HashMap<Character,Integer>();

    public int romanToInt(String s) {
        symbolValue.put('I',1);
        symbolValue.put('V',5);
        symbolValue.put('X',10);
        symbolValue.put('L',50);
        symbolValue.put('C',100);
        symbolValue.put('D',500);
        symbolValue.put('M',1000);
        int sum=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int value=  symbolValue.get(s.charAt(i));
            //i<n-1，完美的在到达最后一个字符时跳出计算
            if (i<n-1&&value<symbolValue.get(s.charAt(i+1))){
                sum=sum-value;//刚开始0-就是负数，没关系，后面再加上就好了
            }else {
                sum=sum+value;
            }
        }
        //最后一个字符(i=n-1)的时候，已经跳转到else中处理了，所以此处不需要再进行操作
        //sum+=symbolValue.get(s.charAt(s.length()-1));
        return sum;
    }
    public static void main(String[] args) {
        exercise13 ex13=new exercise13();
        String s="IV";
        int result=ex13.romanToInt(s);
        System.out.println(result);
    }
}
