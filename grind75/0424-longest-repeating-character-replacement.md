# [424. Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)

## Intuition
슬라이딩 윈도우 기법으로 문제를 해결한다.\
윈도우 안의 문자를 `A ~ Z` 중 하나의 문자로 만든다. 다른 문자가 들어온다면 문자를 변경하는 작업을 수행한다. 
수행 횟수가 초과할 경우, 윈도우를 축소시키며 최장 길이의 윈도우를 찾는다.

## Algorithm
1. `int result`에 결과를 저장한다.
2. 문자 `c`를 `A`부터 `Z`까지 반복하며 아래 작업을 수행한다.
   1. `int operation`에 변경 작업 횟수를 저장한다.
   2. 문자열 `s`를 순회한다. `l`은 윈도우의 왼쪽, `r`은 윈도우의 오른쪽 포인터다.
   3. `r`에 해당하는 문자가 원하는 문자 `c`와 다를 경우 `operation`을 1 증가시킨다.
   4. `operation`이 `k`를 초과할 경우 `l`에 해당하는 문자를 확인하고 `c`와 다를 경우 `operation`을 1 감소시키고 `l`을 증가시킨다.
   5. `result`를 현재 윈도우 길이와 비교해 업데이트한다.
3. `result`를 리턴한다.

## Implementation
```java
class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();

        int result = 0;

        for (char c = 'A'; c <= 'Z'; c++) {
            int operations = 0;

            for (int l = 0, r = 0; r < n; r++) {
                if (s.charAt(r) != c) {
                    operations++;
                }

                while (operations > k) {
                    if (s.charAt(l) != c) {
                        operations--;
                    }
                    l++;
                }

                result = Math.max(result, r - l + 1);
            }
        }

        return result;
    }
}
```

## Complexity
`n`은 문자열 `s`의 길이
- Time complexity: O(n)
- Space complexity: O(1)
