class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return recur(head, null);
    }

    private TreeNode recur(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode mid = getMid(head, tail);
        
        return new TreeNode(mid.val, recur(head, mid), recur(mid.next, tail));
    }

    private ListNode getMid(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
