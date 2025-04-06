package xhjiang.leetcode.coopration;

import java.util.Arrays;

/**
 * @description: 拼多多面试
 * @author: xhjiang
 * @date: 2025/4/3 16:59
 *
 * 从金额中取出面值银币，要求最小硬币数
 * 这是完全背包问题。
 * dp数组有一唯和二维两种解法
 * 面试时写的一维，代码随想录中给的二维，二维更加基础和好理解
 *
 */
public class pdd {
    public int coinChange(int[] coins,int amount){
        int length=coins.length;
        int[][] dp=new int[length][amount+1];//前一位表示硬币种类，后一个表示凑的金额数，
        // 合在一块dp[i][j]表示前i个硬币凑成金额j所需的最小硬币数

        //初始化
//        for (int j = 0; j <= amount; j++) {
//            dp[0][j]=0;//表示0个硬币能凑出来金额j的硬币数为0个
//        }

        for (int i = 0; i <=length; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);//初始化全部为最大值，因为后面要求最小值
            dp[i][0]=0;//初始化金额为0的话所需硬币数为0
        }
        for(int i=1;i<=length;i++){
            for (int j=1;j<=amount;j++) {
                //不选第i个硬币
                dp[i][j]=dp[i-1][j];
                //选择第i个硬币
                if (j>=coins[i-1]) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - coins[i - 1]] + 1);
                }
            }
        }
        return dp[length][amount]==amount+1?-1:dp[length][amount];
    }
}