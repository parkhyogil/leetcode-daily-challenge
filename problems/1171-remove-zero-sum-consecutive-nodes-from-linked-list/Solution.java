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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode res = new ListNode(0, head);

        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, res);

        int sum = 0;

        while (head != null) {
            sum += head.val;

            if (map.containsKey(sum)) {
                ListNode node = map.get(sum).next;
                int x = sum;

                while (node != head) {
                    x += node.val;
                    map.remove(x);
                    node = node.next;
                }

                map.get(sum).next = head.next;
            } else {
                map.put(sum, head);
            }

            head = head.next;
        }

        return res.next;
    }
}
