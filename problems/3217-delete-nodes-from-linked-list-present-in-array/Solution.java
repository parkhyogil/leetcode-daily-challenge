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

        ListNode dummy = new ListNode(-1, head);
        ListNode node = dummy;

        while (node != null) {
            while (node.next != null && set.contains(node.next.val)) {
                node.next = node.next.next;
            }
            node = node.next;
        }

        return dummy.next;
    }
}
