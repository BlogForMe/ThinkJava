package algorlthm.leetcode.basic;

import algorlthm.leetcode.ListNode;

public class Solution_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prevHead = new ListNode(-1);
        ListNode  prev = prevHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if (l1 == null) {
            prev.next = l2;
        }
        if (l2 == null) {
            prev.next = l1;
        }
        return prevHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{1, 2, 4});
        ListNode l2 = new ListNode(new int[]{1, 3, 4});
        System.out.println(new Solution_21().mergeTwoLists(l1, l2));
//[1,1,2,3,4,4]
    }


}

