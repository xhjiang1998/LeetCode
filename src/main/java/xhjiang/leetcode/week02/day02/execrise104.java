package xhjiang.leetcode.week02.day02;

/**
 * @description: 二叉树的最大深度
 * @author: xhjiang
 * @date: 2025/2/18 14:28
 * @description: 给定一个二叉树 root ，返回其最大深度。二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class execrise104 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //递归分别查找左右子树，深度优先DFS
//    public int maxDepth(TreeNode root){
//        if(root == null){
//            return 0;
//        }
//        if (root.left!=null){
//            return maxDepth(root.left)+1;
//        }
//        if (root.right!=null){
//            return maxDepth(root.right)+1;
//        }
//        return 0;
//    }
    public int maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        //当进入到左叶节点时，这里返回1
        int leftDepth=maxDepth(root.left)+1;
        int rightDepth=maxDepth(root.right)+1;
        //这里比较最大值返回
        return Math.max(leftDepth,rightDepth);
    }

    public static void main(String[] args) {
        execrise104 ex104=new execrise104();
        TreeNode treeNode=new execrise104().new TreeNode(1);
        treeNode.left=new execrise104().new TreeNode(2);
        treeNode.right=new execrise104().new TreeNode(3);
        treeNode.right.left=new execrise104().new TreeNode(15);
        treeNode.right.right=new execrise104().new TreeNode(7);
        System.out.println(ex104.maxDepth(treeNode));
    }

    //迭代查找，BFS


}
