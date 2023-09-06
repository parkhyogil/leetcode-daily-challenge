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
        
        ListNode[] res = new ListNode[k];
        res[0] = head;

        for (int i = 0; i < k - 1 && res[i] != null; i++) {
            ListNode node = res[i];
            
            int size = length / k;
            if (i < length % k) {
                size++;
            }

            for (int j = 0; j < size - 1; j++) {
                node = node.next;
            }

            res[i + 1] = node.next;
            node.next = null;
        }
        return res;
    }

    private int getLength(ListNode head) {
        int res = 0;
        while (head != null) {
            head = head.next;
            res++;
        }
        return res;
    }
}
