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
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode();
        ListNode node = res;

        while (head != null) {
            if (head.val == 0) {
                node.next = head.next;
                node = node.next;
            } else {
                node.val += head.next.val;
            }
            head = head.next;
        }

        return res.next;
    }
}
