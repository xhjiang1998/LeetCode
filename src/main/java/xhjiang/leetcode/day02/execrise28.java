package xhjiang.leetcode.day02;

/**
 * @description: 找出字符串中第一个匹配项的下标
 * @author: xhjiang
 * @date: 2025/2/11 09:54
 */
public class execrise28 {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0||haystack.length()<needle.length()){
            return -1;
        }
        for (int i=0;i<haystack.length();i++){
            int start=0;
            if (haystack.charAt(i)==needle.charAt(start)){
                //haystack 依次递增，每次递到一个新位置时，needle从头开始挨个判断
                int iTmp=i;
                int startTmp=start;
                //这里也要加上haystack的边界条件，防止itmp超出边界
                while(startTmp<needle.length()&&iTmp<haystack.length()){
                    if (haystack.charAt(iTmp)==needle.charAt(startTmp)){
                        startTmp++;
                        iTmp++;
                    }else {
                        break;
                    }
                }
                //判断是否完全遍历完needle
                if (startTmp==needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        execrise28 ex28=new execrise28();
        System.out.println(ex28.strStr("mississippi","issipi"));
    }
}
