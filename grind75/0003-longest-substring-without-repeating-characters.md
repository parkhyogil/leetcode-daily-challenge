# [3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)

## Intuition
문자를 추가하다가 중복이 발생하면 왼쪽에서부터 하나씩 지워가면서 답을 찾는다.

## Algorithm
1. `contains` 배열에 문자의 포함 여부를 저장.
2. `r`에 해당하는 문자가 `contains`에 있을 경우, `l`을 증가시키며 `l`에 해당하는 문자를 제거.
3. `r`에 해당하는 문자를 `contains`에 저장
4. 반복되는 문자가 없으니 `res`를 업데이트.

## Implementation
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        boolean[] contains = new boolean[128];

        int res = 0;

        for (int l = 0, r = 0; r < n; r++) {
            while (contains[s.charAt(r)]) {
                contains[s.charAt(l)] = false;
                l++;
            }

            contains[s.charAt(r)] = true;

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
```

## Complexity
- Time complexity: O(n)   
`s`를 순회하여 O(n)의 시간을 사용.

- Space complexity: O(1)   
`contains` 배열에서 상수 공간을 사용.
