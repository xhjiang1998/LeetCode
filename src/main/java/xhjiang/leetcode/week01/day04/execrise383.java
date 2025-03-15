package xhjiang.leetcode.week01.day04;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 赎金信
 * @author: xhjiang
 * @date: 2025/2/13 10:43
 * @description:
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine
 * 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class execrise383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> charMap=new HashMap<>();
        //先存
        for (int i = 0; i < magazine.length(); i++) {
            if (charMap.containsKey(magazine.charAt(i))){
                charMap.put(magazine.charAt(i),
                        charMap.get(magazine.charAt(i))+1);
            }else {
                charMap.put(magazine.charAt(i),1);
            }
        }
        //后取
        for (int i = 0; i < ransomNote.length(); i++) {
            if (charMap.containsKey(ransomNote.charAt(i))&&charMap.get(ransomNote.charAt(i))>0){
                int count=charMap.get(ransomNote.charAt(i))-1;
                charMap.put(ransomNote.charAt(i),count);
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        execrise383 execrise383=new execrise383();
        String ransomNote="aa";
        String magazine="ab";
        System.out.println(execrise383.canConstruct(ransomNote,magazine));
    }
}
