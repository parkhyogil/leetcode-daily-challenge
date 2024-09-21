# [25. Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/description/)

## Intuition
리스트를 순회하며 `k`개의 그룹으로 나눈 후, 각 그룹을 뒤집어 서로 연결한다.

이전 그룹과 현재 그룹을 연결하기 위해 이전 그룹의 꼬리 노드인 `prevGroupTail`을 추적한다.

만약 현재 그룹의 길이가 `k`보다 작으면 뒤집을 수 없으므로, `prevGroupTail`을 현재 노드와 연결하고 종료한다.

그렇지 않다면, 현재 그룹을 뒤집은 리스트의 머리 노드 `groupHead`와 꼬리 노드 `groupTail`을 찾는다.
`groupTail`은 뒤집기 전 리스트의 머리 노드이므로 바로 찾을 수 있다.
`groupHead`는 리스트를 뒤집는 과정에서 `k`번 이동한 노드이다.

그 후, `prevGroupTail`의 다음 노드를 `groupHead`에 연결하고, `prevGroupTail`을 `groupTail`로 변경한 뒤, 다음 그룹으로 넘어간다.

## Implementation
```java
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode dummy = new ListNode();

        ListNode node = head;
        ListNode prevGroupTail = dummy;

        while (true) {
            if (isLengthLessThanK(node, k)) {
                prevGroupTail.next = node;
                break;
            }

            ListNode groupHead = null;
            ListNode groupTail = node;

            for (int i = 0; i < k; i++) {
                ListNode next = node.next;
                node.next = groupHead;
                groupHead = node;
                node = next;
            }

            prevGroupTail.next = groupHead;
            prevGroupTail = groupTail;
        }

        return dummy.next;
    }

    boolean isLengthLessThanK(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            if (head == null) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
```

## Complexity
`n`은 리스트의 길이
- Time complexity: O(n)
- Space complexity: O(1)
