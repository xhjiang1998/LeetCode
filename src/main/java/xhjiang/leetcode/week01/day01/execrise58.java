package xhjiang.leetcode.week01.day01;

public class execrise58 {
    public int lengthOfLastWord(String s) {
        String[] arr=s.split(" ");
        return arr[arr.length-1].length();
    }

    public static void main(String[] args) {
        execrise58 ex58=new execrise58();
        int a=ex58.lengthOfLastWord("hello world xhjiang");
        System.out.println(a);
    }
}
