package xhjiang.leetcode.week04.day02;

/**
 * 加油站问题，猫眼娱乐考过
 *
 * 函数入参gas是当前站所拥有的油量
 * cost是到下一站需要消耗的油量
 * 从其中的一个加油站出发，如果可以顺序跑完一圈，给出起点，如果不行，返回-1
 */
public class execrise134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int curGas=0;
        for (int i = 0; i < gas.length; i++) {
            while(curGas>0){
                totalGas+=gas[i];//总油量
                curGas=totalGas-cost[i];
            }
        }
    }
}