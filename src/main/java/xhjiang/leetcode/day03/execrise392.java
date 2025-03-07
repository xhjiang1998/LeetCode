package xhjiang.leetcode.day03;

/**
 * @description: 判断子序列
 * @author: xhjiang
 * @date: 2025/2/12 09:57
 */
public class execrise392 {
    //判断s是否是t的子序列
    public boolean isSubsequence(String s, String t) {
        if (s.equals("")){
            return true;
        }
        int sIndex=0;
        int tIndex=0;
        while(sIndex<s.length()&&tIndex<t.length()){
            //相同的话都往后挪一步
            if (t.charAt(tIndex)==s.charAt(sIndex)){
                sIndex++;
                tIndex++;
            }
            //不同的话，t往后挪一步，s不动
            else{
                tIndex++;
            }
        }
    return sIndex<s.length()?false:true;
    }

    public static void main(String[] args) {
        execrise392 ex392=new execrise392();
        System.out.println(ex392.isSubsequence("","ahbgdc"));
    }
}
