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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = getLength(head);

        int size = length / k;
        int remainder = length % k;

        ListNode[] result = new ListNode[k];

        for (int i = 0; i < k && head != null; i++) {
            result[i] = head;
            head = sublist(head, (i < remainder ? size + 1 : size));
        }

        return result;
    }

    private ListNode sublist(ListNode head, int fromIndex) {
        int index = 0;

        while (head != null && index < fromIndex - 1) {
            head = head.next;
            index++;
        }

        ListNode newHead = head.next;

        head.next = null;

        return newHead;
    }

    private int getLength(ListNode head) {
        int result = 0;

        while (head != null) {
            head = head.next;
            result++;
        }

        return result;
    }
}
