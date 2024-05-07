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
    public ListNode doubleIt(ListNode head) {
        head = new ListNode(0, head);

        ListNode prev = head;
        ListNode node = head.next;

        while (node != null) {
            prev.val += node.val * 2 / 10;
            node.val = node.val * 2 % 10;

            prev = node;
            node = node.next;
        }

        return head.val == 0 ? head.next : head;
    }
}
