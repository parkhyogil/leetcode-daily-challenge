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
    public int pairSum(ListNode head) {
        List<Integer> vals = new ArrayList<>();
        ListNode node = head;

        while (node != null) {
            vals.add(node.val);
            node = node.next;
        }

        int result = 0;

        node = head;
        for (int i = 0; i < vals.size(); i++) {
            result = Math.max(result, node.val + vals.get(vals.size() - 1 - i));
            node = node.next;
        }

        return result;
    }
}
