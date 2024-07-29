# [328. Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/description/)

## Intuition
리스트를 순회하며 홀수 노드 리스트와 짝수 노드 리스트를 나눈다. 
그 후에 홀수 노드 리스트의 마지막 노드와 짝수 노드 리스트의 첫 번째 노드를 연결하고 홀수 노드 리스트의 첫 번째 노드를 리턴한다.

## Algorithm
1. 변수를 초기화한다.
    - `odd` : 홀수 노드 리스트 포인터
    - `even` : 짝수 노드 리스트 포인터
    - `evenHead` : 짝수 노드 리스트의 첫 번째 노드
2. 짝수 노드의 다음 노드가 있다면 아래를 반복한다.
   1. `odd`의 다음 노드를 `even`의 다음 노드로 연결한다.
   2. `odd`를 다음 노드로 이동한다.
   3. `even`의 다음 노드를 `odd`의 다음 노드로 연결한다.
   4. `even`을 다음 노드로 이동한다.
3. 홀수 노드 리스트의 마지막 노드와 짝수 노드 리스트의 첫 번째 노드를 연결한다.
4. 리스트의 첫 번째 노드를 리턴한다.

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;

        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
```

## Complexity
`n`은 리스트의 길이
- Time complexity: O(n)
- Space complexity: O(1)
