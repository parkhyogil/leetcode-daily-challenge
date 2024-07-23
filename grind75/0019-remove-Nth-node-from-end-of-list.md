# [19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)

## Intuition
`n`번째 노드를 삭제하기 위해 타겟 노드의 이전 노드 포인터와 리스트의 마지막 노드 포인터를 이용한다.
리스트의 마지막 노드와 타겟 노드의 이전 노드의 간격은 `n`이다. 마지막 노드 포인터를 먼저 `n`번 이동하고 마지막 노드 포인터가 리스트의 마지막 노드를 가리킬 때까지 두 포인터를 같이 이동시킨다.
마지막 노드 포인터가 리스트의 끝까지 왔다면 타겟 노드의 이전 노드 포인터로 `n`번째 노드를 삭제할 수 있다.\
리스트의 첫 번째 노드의 이전 노드를 하나 만들고, 사용할 두 포인터의 위치를 첫 번째 노드의 이전 노드에서부터 시작한다.



## Algorithm
1. 주어진 리스트 앞에 노드 `dummy`를 삽입한다.
2. `lastNode`, `prevNodeOfTargetNode` 포인터를 `dummy`노드 위치로 초기화한다.
3. `lastNode`를 `n`번 앞으로 이동시킨다.
4. `lastNode`가 리스트의 마지막 노드를 가리킬 때까지 `lastNode`와 `prevNodeOfTargetNode`를 앞으로 이동시킨다.
5. `prevNodeOfTargetNode`의 다음 노드를 삭제한다.
6. `dummy`의 다음 노드를 리턴한다.

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);

        ListNode lastNode = dummy;
        ListNode prevNodeOfTargetNode = dummy;

        for (int i = 0; i < n; i++) {
            lastNode = lastNode.next;
        }

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            prevNodeOfTargetNode = prevNodeOfTargetNode.next;
        }

        prevNodeOfTargetNode.next = prevNodeOfTargetNode.next.next;

        return dummy.next;
    }
}
```

## Complexity
`n`은 리스트의 길이.
- Time complexity: O(n)
- Space complexity: O(1)
