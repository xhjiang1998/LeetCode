package xhjiang.scene;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @description: LRU缓存的实现:剔除redis中最近最久未使用的key
 * @author: xhjiang
 * @date: 2025/2/24 19:09
 * @description: key命中：命中次数+1，挪到节点头部
 * key未命中，添加到节点头部，如果头部已满，剔除尾部节点
 *
 */
public class CacheLRU {
    /**
     * Node节点定义
     */
    class Node {
        private int key;
        private int value;
        private Node next;
        private Node prev;

        public void Node() {
            this.key = key;
            this.value = value;
            this.prev= prev;
            this.next = next;
        }
    }

    /**
     * 双向链表定义
     */
    class DoubleList{
        private Node head;
        private Node tail;
        private int size;
        public DoubleList(){
            this.head=head;
            this.tail=tail;
            this.size=size;
        }

        /**
         * key命中，挪到节点头部
         */
        private void addFirst(Node node){
            node.next=head;
            node.prev=null;
            size++;
        }
        private void deleteLast(){

        }

    }



    public static void main(String[] args) {
        LinkedList<Integer> cache=new LinkedList<>();
        Stack<Integer> stack=new Stack<>();

    }

}
