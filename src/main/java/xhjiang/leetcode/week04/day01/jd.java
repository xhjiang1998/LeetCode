package xhjiang.leetcode.week04.day01;

/**
 * @description: 京东
 * @author: xhjiang
 * @date: 2025/3/19 19:00
 */
public class jd {
    //实现两个有序链表找第N个最值
    class ListNode {
        ListNode next;
        int val;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
        public int findNthSmallest(ListNode n1,ListNode n2,int n){
            if (n<=0){
                return -1;
            }
            ListNode pA=n1;
            ListNode pB=n2;
            int count=0;
            while (pA!=null&&pB!=null){
                if (pA.val<pB.val){
                    count++;
                    if (count==n){
                        return pA.val;
                    }
                    pA=pA.next;
                }else {
                    count++;
                    if (count==n){
                        return pB.val;

                }
                    pB=pB.next;
            }
        }
            while (pA!=null){
                count++;
                if (count==n){
                    return pA.val;
                }
                pA=pA.next;
                return pA.val;
            }
            while (pB!=null){
                count++;
                if (count==n){
                    return pB.val;
                }
                pB=pB.next;
                return pB.val;
            }
         return 0;
    }

}
