# [76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)

## Intuition
Sliding Window 기법으로 문제를 해결한다.\
오른쪽으로 윈도우를 확장해 나가면서 `t`를 만들 수 있는 조건이 충족된다면 윈도우의 왼쪽을 줄이면서 최소 길이의 문자열을 찾는다.

## Algorithm
1. `m`에 `s`의 길이, `n`에 `t`의 길이를 할당한다.
2. `m < n`일 경우, substring은 존재할 수 없으니 빈 문자열을 반환한다.
3. `minWindowLeft`, `minWindowRight`는 조건에 충족하는 최소 길이 윈도우의 시작과 끝이다. 초기 값으로 `-1`을 할당한다.
4. `charsRequired`는 필요한 문자의 종류의 개수, `charsInWindow`는 현재 윈도우 안에 조건을 충족한 문자의 개수이다. 초기 값으로 `0`을 할당한다.
5. `charsFrequencyRequired`는 필요한 문자의 빈도를 저장한다. `charsFrequencyInWindow`는 윈도우 안의 문자의 빈도를 저장한다.
6. 문자열 `t`를 순회하면서 `charsRequired`, `charsFrequencyRequired`를 갱신한다.
7. `left`와 `right`를 `0`으로 초기화하고 `right < m`이라면 `right`를 증가시키며 아래를 반복한다.
   1. `rightChar`에 `right`가 가리키는 문자를 할당한다.
   2. `charsFrequencyInWindow`의 `rightChar` 빈도를 증가시킨다.
   3. `charsFrequencyInWindow[rightChar] == charsFrequencyRequired[rightChar]`일 경우, `charsInWindow`를 증가시킨다.
   3. `charsInWindow == charsRequired`라면 `t`를 만들 수 있는 조건이니 아래를 반복한다.
      1. 현재 윈도우의 길이가 이전에 찾았던 윈도우의 길이보다 작다면 `minWindowLeft`,`minWindowRight`를 갱신한다.
      2. `leftChar`에 `left`가 가리키는 문자를 할당하고 `left`를 증가시킨다.
      3. `charsFrequencyInWindow[leftChar] == charsFrequencyRequired[leftChar]`일 경우, `charsInWindow`를 감소시킨다.
      4. `charsFrequencyInWindow`의 `leftChar` 빈도를 감소시킨다.
8. substring이 존재하지 않으면 빈 문자열을, 아닐 경우 `minWindowLeft`와 `minWindowRight` 사이의 문자열을 반환한다.

## Implementation
```java
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) {
            return "";
        }

        int minWindowLeft = -1;
        int minWindowRight = -1;

        int charsRequired = 0;
        int charsInWindow = 0;

        int[] charsFrequencyRequired = new int[128];
        int[] charsFrequencyInWindow = new int[128];

        for (char c : t.toCharArray()) {
            if (charsFrequencyRequired[c] == 0) {
                charsRequired++;
            }
            charsFrequencyRequired[c]++;
        }

        for (int left = 0, right = 0; right < m; right++) {
            char rightChar = s.charAt(right);

            charsFrequencyInWindow[rightChar]++;
            if (charsFrequencyInWindow[rightChar] == charsFrequencyRequired[rightChar]) {
                charsInWindow++;
            }

            while (charsInWindow == charsRequired) {
                if (minWindowLeft == -1 || minWindowRight - minWindowLeft > right - left) {
                    minWindowLeft = left;
                    minWindowRight = right;
                }

                char leftChar = s.charAt(left++);

                if (charsFrequencyInWindow[leftChar] == charsFrequencyRequired[leftChar]) {
                    charsInWindow--;
                }
                charsFrequencyInWindow[leftChar]--;
            }
        }

        return minWindowLeft == -1 ? "" : s.substring(minWindowLeft, minWindowRight + 1);
    }
}
```

## Complexity
`m`은 문자열 `s`의 길이, `n`은 문자열 `t`의 길이
- Time complexity: O(m + n)
- Space complexity: O(1)
