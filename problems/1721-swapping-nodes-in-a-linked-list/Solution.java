class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode s = head;
        ListNode f = head;

        while (k-- > 1) {
            f = f.next;
        }

        ListNode left = f;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next;
        }

        ListNode right = s;

        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;

        return head;        
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
