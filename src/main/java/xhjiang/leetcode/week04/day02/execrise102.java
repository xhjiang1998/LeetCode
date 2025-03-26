package xhjiang.leetcode.week04.day02;

import java.util.*;

/**
 * 二叉树的层序遍历
 * 采用的是BFS，广度优先搜索
 */
public class execrise102 {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //二叉树的层序遍历必须要用到Queue队列，有两个实现类LinkedList和QueuePrority
        Queue<TreeNode> queue = new LinkedList<>();
        // offer表入对，poll表出队，peek表查看但不移除队长元素
        queue.offer(root);

        //队列不空的话,
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            //遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                //从队列中取出一个节点
                TreeNode node = queue.poll();
                level.add(node.val);
                //将下一层的子节点加入队列
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }


    /**
     * DFS解法
     * 上面解法为广度优先解法
     */
    public List<List<Integer>> DFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //层和层元素的map
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, 0, map);
        for (int level = 0; map.containsKey(level); level++) {
            res.add(map.get(level));
        }
        return res;
    }

    private void dfs(TreeNode node, int i, Map<Integer, List<Integer>> map) {
        if (node == null) return;
        if (node.right != null) dfs(node.right, i + 1, map);
        if (node.left != null) dfs(node.left, i + 1, map);
        //递归到最底层N的时候，执行62行代码
        //递归到N-1层的时候，单节点情况执行下面代码，压入层和层的节点list
        if (map.get(i) == null) {//当前层节点还没list，我就将这层list添加进去
            List<Integer> res = new ArrayList<>();
            map.put(i,res);
        }
        List<Integer>res=map.get(i);
        res.add(node.val);
        map.put(i,res);
        }


    public static void main(String[] args) {
        execrise102 solution = new execrise102();
        // 构造测试用例
        TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(3);
        root.left.left = solution.new TreeNode(4);
        root.left.right = solution.new TreeNode(5);
        root.right.left = solution.new TreeNode(6);
        root.right.right = solution.new TreeNode(7);

        // 执行层序遍历
        List<List<Integer>> result = solution.DFS(root);

        // 打印输出
        System.out.println("层序遍历结果：");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }

}
