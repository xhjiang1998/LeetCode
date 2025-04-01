package xhjiang.leetcode.week04.mon;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。你可以按任意顺序返回答案。
 * 回溯算法中的组合问题
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * k=2的话for循环是两层，k为N的话就是N层了，所以这里不能用for循环
 */
public class execrise77 {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        int start=1;
        backtrack(start,n,k,path,ans);
        return ans;
    }
    //1、递归函数的返回值以及参数
    void backtrack(int start,int n,int k,List<Integer> path,
                   List<List<Integer>> ans){
        //2、回溯函数终止条件
        if(path.size()==k){
            ans.add(new ArrayList<>(path));
            return;
        }
        //3、单层搜索的过程
        for (int i=start;i<=n;i++){
            //选择当前数字，加入元组中
            path.add(i);
            //递归搜索下一个数字，递归加入元祖
            backtrack(i+1,n,k,path,ans);
            //还需要将后续元素挪除，给第二个元素腾位置
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        execrise77 execrise77=new execrise77();
        List<List<Integer>> combine = execrise77.combine(4, 2);
        combine.stream().forEach(System.out::println);
    }
}
