package xhjiang.leetcode.week04.day02;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 */
public class execrise144 {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val,TreeNode left,TreeNode right){this.val=val;this.left=left;this.right=right;}
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes=new ArrayList<>();
        dfs(root,nodes);
        return nodes;
    }

    private void dfs(TreeNode root, List<Integer> nodes) {
        if (root==null){
            return;
        }
        nodes.add(root.val);
        dfs(root.left,nodes);
        dfs(root.right,nodes);
    }

    public static void main(String[] args) {
        execrise144 solution=new execrise144();
        // 创建二叉树
        TreeNode root = solution.new TreeNode(1);
        root.right = solution.new TreeNode(2);
        root.right.left = solution.new TreeNode(3);

        List<Integer> result = solution.preorderTraversal(root);

        // 输出遍历结果
        System.out.println("前序遍历结果: " + result); // 预期输出: [1, 2, 3]
    }
}
