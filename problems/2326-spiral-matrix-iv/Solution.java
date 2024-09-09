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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];

        int rowTop = 0;
        int rowBottom = m - 1;
        int colLeft = 0;
        int colRight = n - 1;
        int value;

        while (rowTop < rowBottom && colLeft < colRight) {
            for (int i = colLeft; i < colRight; i++) {
                if (head == null) {
                    value = -1;
                } else {
                    value = head.val;
                    head = head.next;
                }
                result[rowTop][i] = value;
            }

            for (int i = rowTop; i < rowBottom; i++) {
                if (head == null) {
                    value = -1;
                } else {
                    value = head.val;
                    head = head.next;
                }
                result[i][colRight] = value;
            }

            for (int i = colRight; i > colLeft; i--) {
                if (head == null) {
                    value = -1;
                } else {
                    value = head.val;
                    head = head.next;
                }
                result[rowBottom][i] = value;
            }

            for (int i = rowBottom; i > rowTop; i--) {
                if (head == null) {
                    value = -1;
                } else {
                    value = head.val;
                    head = head.next;
                }
                result[i][colLeft] = value;
            }

            rowTop++;
            rowBottom--;
            colLeft++;
            colRight--;
        }

        if (rowTop == rowBottom) {
            for (int i = colLeft; i <= colRight; i++) {
                if (head == null) {
                    value = -1;
                } else {
                    value = head.val;
                    head = head.next;
                }
                result[rowTop][i] = value;
            }
        } else if (colLeft == colRight) {
            for (int i = rowTop; i <= rowBottom; i++) {
                if (head == null) {
                    value = -1;
                } else {
                    value = head.val;
                    head = head.next;
                }
                result[i][colRight] = value;
            }
        }

        return result;
    }
}
