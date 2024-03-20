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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode fast = list1;
        ListNode slow = list1;

        for (int i = 0; i < b - a + 1; i++) {
            fast = fast.next;
        }

        for (int i = 0; i < a - 1; i++) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = list2;
        while (slow.next != null) {
            slow = slow.next;
        }

        slow.next = fast.next;

        return list1;
    }
}
