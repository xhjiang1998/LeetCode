package xhjiang.leetcode.week02.day03;

/**
 * @description: 相同的树
 * @author: xhjiang
 * @date: 2025/2/19 10:46
 * @description: 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 小窍门：
 * 对于递归和树问题，先写递归基，即最简单的情况，避免无限递归
 * 在继续写递归函数时，要假设这个递归函数已经能正确处理子问题
 * 利用中间变量存储中间结果
 */
public class execrise100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null){
            return true;
        }
        //如果只有一个节点为空，或者节点值不同，则不同
        if (p==null||q==null||p.val!=q.val){
            return false;
        }
        boolean left=isSameTree(p.left,q.left);
        boolean right=isSameTree(p.right,q.right);
        //左右子树都相同返回true
        return left&&right;

    }

    public static void main(String[] args) {
        execrise100 ex100=new execrise100();
        TreeNode treeNode=new execrise100().new TreeNode(1);
        treeNode.left=new execrise100().new TreeNode(2);
        treeNode.right=new execrise100().new TreeNode(3);
        treeNode.right.left=new execrise100().new TreeNode(15);
        treeNode.right.right=new execrise100().new TreeNode(7);
        System.out.println(ex100.isSameTree(treeNode,treeNode));
    }
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
}
