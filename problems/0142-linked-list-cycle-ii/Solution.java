public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        boolean hasCycle = false;

        while (f != null && f.next != null && !hasCycle) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                hasCycle = true;
            }
        }

        if (!hasCycle) {
            return null;
        }

        s = head;
        while (s != f) {
            s = s.next;
            f = f.next;
        }
        return s;
    }
}
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
