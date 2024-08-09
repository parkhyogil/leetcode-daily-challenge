# [148. Sort List](https://leetcode.com/problems/sort-list/description/)

## Intuition
병합 정렬로 `O(nlogn)`의 시간 복잡도로 링크드 리스트를 정렬할 수 있다.

## Algorithm
- `sortList` 메소드 : 링크드 리스트를 정렬한다.
  - `head == null || head.next == null`이라면 `head`를 리턴한다
  - 리스트를 반으로 나누고 나눠진 오른쪽 리스트의 헤드를 `rightList`에 할당한다.
  - 두 개로 나뉜 리스트를 정렬하고 병합한 뒤 병합한 리스트의 헤드를 리턴한다.
- `merge` 메소드 : 정렬된 두 리스트를 받아 병합한다.
  - 더미 노드를 하나 만들고 두 리스트 중 작은 값을 가진 노드를 병합된 리스트 뒤에 추가한다.
  - 모든 노드를 병합하고 더미 노드의 다음 노드를 리턴한다.
- `splitList` 메소드 : 링크드 리스트를 받아 반으로 나누고 오른쪽 리스트의 헤드를 리턴한다.
  - 리스트의 중간을 찾기 위해 `slow` 포인터는 한 칸, `fast` 포인터는 두 칸씩 이동한다.
  - `fast`가 리스트의 끝일 때 `slow`는 리스트의 중간 노드이다. 두 리스트의 연결을 끊고 `slow`의 다음 노드를 리턴한다.

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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode rightList = splitList(head);

        return merge(sortList(head), sortList(rightList));
    }

    private ListNode merge(ListNode leftList, ListNode rightList) {
        ListNode head = new ListNode();
        ListNode node = head;

        while (leftList != null && rightList != null) {
            if (leftList.val <= rightList.val) {
                node.next = leftList;
                leftList = leftList.next;
            } else {
                node.next = rightList;
                rightList = rightList.next;
            }
            node = node.next;
        }

        if (leftList == null) {
            node.next = rightList;
        } else {
            node.next = leftList;
        }

        return head.next;
    }

    private ListNode splitList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rightList = slow.next;
        slow.next = null;

        return rightList;
    }
}
```

## Complexity
`n`은 리스트의 길이
- Time complexity: O(nlogn)
- Space complexity: O(logn)
