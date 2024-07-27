# [24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)

## Intuition
재귀함수를 이용해 문제를 해결할 수 있다.

## Algorithm
1. 현재 노드가 `null`이거나 노드의 다음 노드가 `null`이라면 뒤집을 수 없으니 현재 노드를 리턴한다.
2. 쌍의 첫 번째 노드를 `a`, 두 번째 노드를 `b`에 할당한다.
3. `a`의 다음 노드는 재귀함수를 호출해 `b`의 다음 노드를 뒤집은 쌍의 첫 번째 노드가 된다.
4. `b`의 다음 노드는 `a`가 된다.
4. 쌍의 첫 번째 노드인 `b`를 리턴한다.

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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode a = head;
        ListNode b = head.next;

        a.next = swapPairs(b.next);
        b.next = a;

        return b;
    }
}
```

## Complexity
`n`은 리스트의 길이.
- Time complexity: O(n)
- Space complexity: O(n)
