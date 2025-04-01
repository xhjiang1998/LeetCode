package xhjiang.leetcode.week04.day01;

/**
 * @description: 滴滴
 * @author: xhjiang
 * @date: 2025/3/31 20:32
 */
public class Didi {
    private boolean isSubString(String s,int start, int end){
        while (start<end){
            if (s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public String longestSubString(String s){
        if (s==null||s.length()<1){
            return "";
        }
        String longest="";
        for (int i=0;i<s.length();i++){
            for (int j = i; j < s.length(); j++) {
                if (isSubString(s,i,j)){
                    String currentSubString=s.substring(i,j+1);
                    if (currentSubString.length()>longest.length()){
                        longest=currentSubString;
                    }
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Didi didi=new Didi();
        String input="babad";
        System.out.println(didi.longestSubString(input));
    }

}
