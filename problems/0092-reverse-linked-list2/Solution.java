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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        head = new ListNode(0, head);

        int idx = 0;
        ListNode node = head;
        for (int i = 0; i < left - 1; i++) {
            node = node.next;
        }

        ListNode leftEndNode = node;
        ListNode rightEndNode = node.next;

        node = rightEndNode;
        ListNode prev = null;
        for (int i = left; i <= right; i++) {
            ListNode next = node.next;

            node.next = prev;
            prev = node;

            if (i == right) {
                leftEndNode.next = node;
                rightEndNode.next = next;
            }

            node = next;
        }

        return head.next;
    }
}
