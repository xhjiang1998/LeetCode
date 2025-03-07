package xhjiang.leetcode.day01;

/**
 * @description: 最长公共前缀
 * @author: xhjiang
 * @date: 2025/2/10 21:48
 */
public class execrise14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String  prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            //indexOf 返回的是字符串中第一个匹配的字符串的索引位置，如果找不到，则返回-1
            //返回为0表示该字符串就是prefix
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.equals("")){
                    return "";
                }
            }
        }
        return prefix;
    }
}
