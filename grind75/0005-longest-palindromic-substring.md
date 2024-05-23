# [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/description/)

## Intuition
하나의 인덱스를 가운데로 설정하고 양쪽으로 확장해 나가면서 팰린드롬인지 확인한다.\
모든 인덱스에 같은 작업을 해서 최대 길이 팰린드롬 문자열을 리턴한다.

## Algorithm
1. `s`의 길이를 저장할 `n`, 최대 팰린드롬 문자열의 시작과 끝을 저장할 `maxLeft`, `maxRight` 선언.
2. `left`, `right`에 현재 인덱스 `i`로 초기화.
3. `s.charAt(left) == s.charAt(right)`라면 양쪽으로 확장.
4. 현재 팰린드롬 길이가 더 길다면 `maxLeft`, `maxRight` 업데이트.
5. 길이가 짝수인 팰린드롬을 확인하기 위해 `left`를 `i`, `right`를 `i + 1`로 초기화하고 3-4번과 같은 작업을 실행.
6. 최대 길이 팰린드롬 문자열을 리턴.

## Implementation
```java
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

        int maxLeft = 0;
        int maxRight = -1;

        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            if (right - left > maxRight - maxLeft) {
                maxLeft = left;
                maxRight = right;
            }

            left = i;
            right = i + 1;

            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            if (right - left > maxRight - maxLeft) {
                maxLeft = left;
                maxRight = right;
            }
        }

        return s.substring(maxLeft + 1, maxRight);
    }
}
```

## Complexity
`n`은 문자열 `s`의 길이.
- Time complexity: O(n^2)\
`n`번 양쪽으로 확장하는데 사용한 시간.

- Space complexity: O(1)\
상수 공간을 사용.
