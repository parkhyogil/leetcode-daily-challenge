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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int min = Integer.MAX_VALUE;
        int max = -1;

        int i = 1;
        int f = -1;
        int p = -1;

        while (head.next != null && head.next.next != null) {
            int a = head.val;
            int b = head.next.val;
            int c = head.next.next.val;

            if ((a > b && b < c) || (a < b && b > c)) {
                if (p == -1) {
                    f = i;
                } else {
                    max = Math.max(max, i - f);
                    min = Math.min(min, i - p);
                }
                p = i;
            }

            head = head.next;
            i++;
        }

        return max == -1 ? new int[] {-1, -1} : new int[] {min, max};
    }
}
