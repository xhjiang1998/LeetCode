package xhjiang.leetcode.day05;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 环形链表
 * @author: xhjiang
 * @date: 2025/2/13 11:38
 */
public class execrise141 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        }
    }
    public boolean hasCycle(ListNode head) {
        // 判断是否有环，仅需要遍历一遍链表，将每个元素的引用存储到set集合中，如果出现重复的，则说明有环
        if(head==null||head.next==null){
            return false;
        }
//        StringBuffer stringBuffer=new StringBuffer(); 线程安全的可变字符序列
        Set<ListNode> nodeSet=new HashSet<>();
        ListNode tmp=head;
        while (tmp.next!=null){
            if(!nodeSet.add(tmp.next)){//如果有重复元素导致添加失败
                return true;
            }
            tmp=tmp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        execrise141 execrise141=new execrise141();
        ListNode listNode=new execrise141().new ListNode(1);
        listNode.next=new execrise141().new ListNode(2);
        listNode.next.next=new execrise141().new ListNode(3);
        listNode.next.next.next=listNode.next;
        System.out.println(execrise141.hasCycle(listNode));
    }
}
