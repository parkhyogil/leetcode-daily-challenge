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
        List<Integer> criticalPoints = getCriticalPoints(head);

        int size = criticalPoints.size();

        if (size < 2) {
            return new int[] {-1, -1};
        }

        int minDist = Integer.MAX_VALUE;
        int maxDist = criticalPoints.get(size - 1) - criticalPoints.get(0);

        for (int i = 1; i < size; i++) {
            minDist = Math.min(minDist, criticalPoints.get(i) - criticalPoints.get(i - 1));
        }

        return new int[] {minDist, maxDist};
    }

    private List<Integer> getCriticalPoints(ListNode head) {
        ListNode prev = new ListNode(head.val);

        List<Integer> res = new ArrayList<>();
        int idx = 0;

        while (head.next != null) {
            if ((prev.val < head.val && head.val > head.next.val) || (prev.val > head.val && head.val < head.next.val)) {
                res.add(idx);
            }
            
            prev = head;
            head = head.next;
            idx++;
        }

        return res;
    }
}
