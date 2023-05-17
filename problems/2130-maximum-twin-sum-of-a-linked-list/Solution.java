class Solution {
    public int pairSum(ListNode head) {
        ListNode s = head;
        ListNode f = head;

        ListNode left = null;
        while (f != null && f.next != null) {
            ListNode sTmp = s.next;
            f = f.next.next;

            s.next = left;
            left = s;
            s = sTmp;
        }

        ListNode right = s;
        
        int res = 0;
        while (left != null) {
            res = Math.max(res, left.val + right.val);
            left = left.next;
            right = right.next;
        }
        return res;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
