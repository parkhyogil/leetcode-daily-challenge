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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int n = getLength(head);

        k %= n;

        if (k == 0) {
            return head;
        }

        ListNode node = head;

        for (int i = 0; i < n - k - 1; i++) {
            node = node.next;
        }

        ListNode result = node.next;
        node.next = null;

        node = result;

        while (node.next != null) {
            node = node.next;
        }

        node.next = head;

        return result;
    }

    int getLength(ListNode head) {
        int length = 0;

        while (head != null) {
            head = head.next;
            length++;
        }

        return length;
    }
}
