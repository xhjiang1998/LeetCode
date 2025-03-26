package xhjiang.leetcode.week04.day02;

/**
 * 加油站问题，猫眼娱乐考过
 *
 * 函数入参gas是当前站所拥有的油量
 * cost是到下一站需要消耗的油量
 * 从其中的一个加油站出发，如果可以顺序跑完一圈，给出起点，如果不行，返回-1
 *
 * 下面分析贪心算法的可行性，只扫描一遍，也不会出现漏解。
 * 假如依次过以下九个点：123456789，按照贪心算法，我先判断从1出发，假设走到5发现行不通，那就选取5作为新出发点，继续往下判断。这种算法的问题在于：有没有可能漏掉了24之间作为出发点的情况呢？答案是不会的。
 * 我这里以2出发举例，即希望2→5，那这时候在点2的开始处油量一定就是0，这是题目中初试油量0决定的，那么这就已经劣于方案一经过点2时的油量了，我方案一在点2处的油量更高，都无法顺利过5到6，那你方案二在点2处的油量比我还低，有什么资格比我走的更远？即方案2必然在点5处甚至更前面就失败了。
 * 综上所述，如果1→5发现失败，那么选取24作为出发点必然是失败的，因此，贪心算法不必再考虑24作为出发点了，直接从失败处点5作为出发点。相较于暴力算法，此贪心省去了一些不必要的趟次（暴力算法即把每个点都作为出发点判断一下，这是平方级别的复杂度）。
 */
public class execrise134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int curGas=0;
        int start=0;
        for (int i = 0; i < gas.length; i++) {
                totalGas+=gas[i]-cost[i];//全程的油量剩余，最后可直接判断是否大于或小于0来表明能否走完全程
                curGas+=gas[i]-cost[i];//用来表明从哪个节点能走完全程
                //如果当前油量小于0，那么就直接从下一个点开始
                if (curGas<0){
                    start=i+1;
                    curGas=0;//重置当前油量
                }
        }
        return totalGas>=0?start:-1;
    }

    //可读性更好的代码
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int startIdx = 0; // 始发站
        int curGas = 0; // 到达下一个加油站加油之前的累计剩余油量
        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                // 走不动了, 说明之前的始发站不行，从i+1重新出发
                startIdx = i + 1;
                curGas = 0;
            }
        }
        // 判断累计剩余油量能否走完startIdx之前的加油站
        for (int i = 0; i < startIdx; i++) {
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                return -1;
            }
        }
        return startIdx;
    }

    public static void main(String[] args) {
        execrise134 solution = new execrise134();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(solution.canCompleteCircuit(gas, cost)); // 输出 3
    }
}