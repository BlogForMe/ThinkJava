package main.java.algorlthm.leetcode.linklist;

// 160. 相交链表
//https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/?utm_source=LCUS&utm_medium=ip_redirect&utm_campaign=transfer2china
public class Solution_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode la = headA;
        ListNode lb = headB;

        while(la!=lb){
            la = (la==null) ? headB : la.next;
            lb = (lb==null) ? headA : lb.next ;
        }
        return la;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
