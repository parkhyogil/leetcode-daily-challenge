# [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/description/)

## Intuition
두 리스트를 순회하며 각 노드의 값을 더하고, 올림수를 다음 노드의 계산에 사용한다.

## Algorithm
1. 변수를 초기화한다.
   - `ListNode node` : 새로운 리스트의 마지막 노드
   - `ListNode result` : 새로운 리스트의 첫 번째 노드의 이전 더미 노드
   - `int carry` : 두 리스트의 값을 더한 후 다음 덧셈으로 넘길 값
2. `l1 != null || l2 != null || carry != 0`이라면 아래를 반복한다.
   1. `int value`에 현재 덧셈 단계의 값을 저장한다. 이전에 넘어온 `carry`를 더한다.
   2. 리스트 `l1` 노드가 `null`이 아니라면 `value`에 값을 더하고 다음 노드로 넘어간다.
   3. 리스트 `l2` 노드가 `null`이 아니라면 `value`에 값을 더하고 다음 노드로 넘어간다.
   4. `node`의 다음 노드를 현재 덧셈 단계의 값을 10으로 나눈 나머지로 만들고 다음 노드로 넘어간다.
   5. `carry`는 현재 덧셈 단계의 값을 10으로 나는 몫이 된다.
3. `result`의 다음 노드를 리턴한다.

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode result = node;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int value = carry;

            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }

            node.next = new ListNode(value % 10);
            node = node.next;
            
            carry = value / 10;
        }

        return result.next;
    }
}
```

## Complexity
`m`은 리스트 `l1`의 길이, `n`은 리스트 `l2`의 길이
- Time complexity: O(max(m, n))
- Space complexity: O(max(m, n))
