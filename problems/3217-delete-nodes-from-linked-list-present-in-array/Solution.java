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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        ListNode result = new ListNode(0, head);

        ListNode prev = result;

        while (head != null) {
            if (set.contains(head.val)) {
                prev.next = head.next;
                head.next = null;
                head = prev.next;
            } else {
                prev = head;
                head = head.next;
            }
        }

        return result.next;
    }
}
