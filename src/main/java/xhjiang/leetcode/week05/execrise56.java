package xhjiang.leetcode.week05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 合并重叠区间问题
 * @author: xhjiang
 * @date: 2025/4/1 19:43
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class execrise56 {
    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);//lambda写法，减法结果为负的话，a就会排在b
        // 前面，这是个java8新写法

        List<int[]> list=new ArrayList<>();//定义结果集，在结果集中进行添加和合并操作
        for (int i=0;i<intervals.length;i++){
            if (list.isEmpty()||list.get(list.size()-1)[1]<intervals[i][0]){
                //合并区间
                list.add(intervals[i]);
            }else {
                int maxValue=Math.max(list.get(list.size()-1)[1],
                        intervals[i][1]);
                list.get(list.size()-1)[1]=maxValue;
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    // 可以带一个测试主函数，验证逻辑是否正确
    public static void main(String[] args) {
        execrise56 solver = new execrise56();
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solver.merge(input);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

