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
    List<Integer> vals;

    public Solution(ListNode head) {
        vals = new ArrayList<>();

        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }    
    }
    
    public int getRandom() {
        return vals.get((int) (Math.random() * vals.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
