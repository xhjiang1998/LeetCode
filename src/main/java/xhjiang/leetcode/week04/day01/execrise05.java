package xhjiang.leetcode.week04.day01;

/**
 * 最长回文子串
 * （正反读都是一样的最长的子串）
 * 1、从中心扩展发展
 */

public class execrise05 {
    public String longestPalindrome(String s) {
        if(s.length()<2||s==null){
            return s;
        }
        int maxLen=0;
        int start=0;//用来标记回文起点的
        //从中心向两边扩展
        for (int i = 0; i < s.length(); i++) {
            int len=expand(s,i,i);
            int len2=expand(s,i,i+1);
            int length=Math.max(len,len2);//取两者的最大长度
            if (length>maxLen){
                start=i-(length-1)/2;
                maxLen=length;
            }
        }
        return s.substring(start,maxLen+start);
    }

    private int expand(String s, int left, int right) {
        while(left>=0&&right<s.length()&&s.charAt(right)==s.charAt(left)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        execrise05 solution = new execrise05();
        System.out.println(solution.longestPalindrome("babad")); // 输出: "bab" 或 "aba"
        System.out.println(solution.longestPalindrome("cbbd"));  // 输出: "bb"
    }
}
