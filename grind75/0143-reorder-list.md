# [143. Reorder List](https://leetcode.com/problems/reorder-list/description/)

## Intuition
주어진 리스트를 반으로 나누고, 오른쪽 리스트를 뒤집은 다음, 두 리스트의 노드를 번갈아가며 연결한다.

## Algorithm
- `reorderList` 메소드 : 주어진 리스트를 `L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …` 형식으로 재정렬한다.
  1. `leftList`에 `head`를 할당한다.
  2. `rightList`에 오른쪽 리스트의 헤드를 할당한다. `splitList`를 호출해 리스트를 반으로 나누고, `reverseList`를 호출해 오른쪽 리스트를 뒤집는다.
  3. 두 리스트의 헤드 노드를 번갈아가며 연결한다.
- `reverseList` 메소드 : 주어진 리스트를 뒤집고 헤드를 반환한다.
  1. `prev`노드에 이전 노드를 할당한다.
  2. 리스트를 순회하며 현재 노드의 다음 노드를 이전 노드로 연결한다.
  3. 뒤집은 리스트의 헤드인 이전 노드를 반환한다.
- `splitList` 메소드 : 주어진 리스트를 반으로 나누고 오른쪽 리스트의 헤드를 반환한다.
  1. `fast`노드는 `slow`노드의 두 배로 움직인다. `fast`노드가 리스트의 끝이라면 `slow`노드는 리스트의 중간 노드이다.
  2. `slow`노드의 다음 노드와 연결은 끊고 다음 노드를 반환한다.

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
    public void reorderList(ListNode head) {
        ListNode leftList = head;
        ListNode rightList = reverseList(splitList(head));

        while (leftList != null && rightList != null) {
            ListNode nextRightList = rightList.next;

            rightList.next = leftList.next;
            leftList.next = rightList;

            leftList = rightList.next;
            rightList = nextRightList;
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;

            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    private ListNode splitList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode result = slow.next;
        slow.next = null;

        return result;
    }
}
```

## Complexity
`n`은 리스트의 길이
- Time complexity: O(n)

- Space complexity: O(1)
