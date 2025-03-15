package xhjiang.leetcode.week04.day01;

/**
 * 最长公共子串
 * 求两个串A和B的最长公共子串
 */
public class execrise04 {
    public static String longestCommonSubstring(String A ,String B ){
        int m=A.length();
        int n=B.length();
        //定义dp数组
        int [][]dp=new int[m+1][n+1];
        int maxLen=0;
        int endIndex=0;
        //遍历字符串A和B
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if (A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                if (dp[i][j]>maxLen){
                    //更新最大长度
                    maxLen=dp[i][j];
                    //更新子串位置
                    endIndex=i;
                }
            }
        }
        return A.substring(endIndex-maxLen,endIndex);
    }

    public static void main(String[] args) {
        // 测试用例
        System.out.println(longestCommonSubstring("abcde", "bcdf")); // 输出: "bcd"
        System.out.println(longestCommonSubstring("abcdefg", "xyzabc")); // 输出: "abc"
    }
}
