package xhjiang.leetcode.week04.day01;

import java.util.List;

/**
 * 合并K个升序链表
 *
 */

public class execrise23 {
    class ListNode{
        ListNode next;
        int val;
        ListNode(){}
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        //首先是判断,这里给的函数入参lists是一个ListNode类型的数组
        if (lists==null||lists.length==0){
            return null;
        }
        return merge(lists,0,lists.length-1);
    }

    //第一步、分解
    public ListNode merge(ListNode[] listNodes,int left,int right){
        if (left==right){
            return listNodes[left];
        }
        int mid=left+(right-left)/2;
        //不断拆分lists，直至每个子问题只剩下一个链表
        ListNode n1=merge(listNodes,left,mid);
        ListNode n2=merge(listNodes,mid+1,right);
        //当递归到最底层N的时候return单节点，即34行语句
        //return完回到N+1层，N+1层做两个链表的合并，即下面执行的语句
        return mergeTwoListNode(n1,n2);
    }

    //第二步，合并
    private ListNode mergeTwoListNode(ListNode n1, ListNode n2) {
        //如何将两个有序链表合并成一个有序链表？
        ListNode dummy=new ListNode();  //头节点
        ListNode tmp=dummy;    //遍历节点
        while(n1!=null&&n2!=null){
            if (n1.val<n2.val){
                tmp.next=n1;
                n1=n1.next;
            }
            else{
                tmp.next=n2;
                n2=n2.next;
            }
            tmp=tmp.next;
        }
        if (n1==null){
            tmp.next=n2;
        }
        if (n2==null){
            tmp.next=n1;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        // 创建测试用例
        execrise23 solution=new execrise23();
        ListNode l1 = solution.new ListNode(1);
        l1.next = solution.new ListNode(4);
        l1.next.next = solution.new ListNode(5);

        ListNode l2 = solution.new ListNode(1);
        l2.next = solution.new ListNode(3);
        l2.next.next = solution.new ListNode(4);

        ListNode l3 = solution.new ListNode(2);
        l3.next = solution.new ListNode(6);

        ListNode[] lists = {l1, l2, l3};
        ListNode result = solution.mergeKLists(lists);

        // 输出合并后的链表
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }

}


