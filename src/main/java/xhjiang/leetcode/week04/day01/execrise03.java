package xhjiang.leetcode.week04.day01;

import java.util.HashSet;

/**
 * @description: 无重复字符的最长子串
 * 给定一个字符串s，找出其中不含有重复字符的最长子串的长度
 * <p>
 *
 */
public class execrise03 {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                //剔除左元素
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(right - left+1, maxLen);
        }
        return maxLen;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 输出: 3 ("abc")
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 输出: 1 ("b")
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 输出: 3 ("wke")
    }
}
