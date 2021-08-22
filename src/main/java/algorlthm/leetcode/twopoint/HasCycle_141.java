package algorlthm.leetcode.twopoint;

/**
 * 6. 判断链表是否存在环
 */
public class HasCycle_141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // 如果走到p2为null则走完了,p1走一步 p2走两步如果能相遇，说明存在环，这题输入输出没用到
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode p1 = head, p2 = head.next;

        while (p2!=null&&p2.next!=null){ // p2是p1的next所有 p1不需要判null
            if (p1 == p2) {
                return true;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
      return false;
    }



}
