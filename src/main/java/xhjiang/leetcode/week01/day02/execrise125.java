package xhjiang.leetcode.week01.day02;

/**
 * @description: 验证回文串
 * @author: xhjiang
 * @date: 2025/2/11 11:03
 */
public class execrise125 {
    public boolean isPalindrome(String s) {
        // 首先判断是否为空，如果为空直接返回true
        if (s.equals(" ")||s.length()==1){
            return true;
        }
        //使用双指针法从左右两侧到中间移动，遇到非字母/数字就跳过。
        int left=0;
        int right=s.length()-1;
        // 很好的思路，从两边往中间找，可以以左右边界为while的条件
        while(left<=right){
            // 不是数字或字母的话就疯狂往中间挪
            while (!Character.isLetterOrDigit(s.charAt(left)) && left < right) {
                left++;
            }
            // 不是数字或字母的话就疯狂往中间挪
            while (!Character.isLetterOrDigit(s.charAt(right))&&left<right){
                right--;
            }
            // 现在两边都是数字和字母了，可以比较了
            if(Character.isLetterOrDigit(s.charAt(left))&&Character.isLetterOrDigit(s.charAt(right))) {
                //只要有一个不同，立马直接false
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        execrise125 ex125=new execrise125();
        System.out.println(ex125.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
