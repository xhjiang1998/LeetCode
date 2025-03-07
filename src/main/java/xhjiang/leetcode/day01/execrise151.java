package xhjiang.leetcode.day01;

/**
 * @description: 反转字符串中的单词
 * @author: xhjiang
 * @date: 2025/2/10 22:17
 */
public class execrise151 {
    public String reverseWords(String s){
        String[] arr=s.split(" ");//两个空格分割后结果为空字符串
        int n=arr.length;
        StringBuffer stringBuffer=new StringBuffer();
        for (int i=n-1;i>=0;i--) {
            if (!arr[i].equals("")) {//所以此处equals.""
                stringBuffer.append(arr[i]);
                if (i != 0) {
                    stringBuffer.append(" ");
                }
            }
        }
        return stringBuffer.toString().trim();//trim()去除首尾空格
    }

    public static void main(String[] args) {
        execrise151 ex151=new execrise151();
        String s="  hello world  ";
        System.out.println(ex151.reverseWords(s));
    }
}
