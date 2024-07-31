# [394. Decode String](https://leetcode.com/problems/decode-string/description/)

## Intuition
재귀 함수를 이용해 문제를 해결한다.\
`k[string]` 부분이 나오면  괄호 안의 문자열을 재귀 함수를 호출해 복호화하고 현재 작업 중인 문자열에 `k`번 붙여넣는다.

## Algorithm
1. 문자열 인덱스 `idx`를 0으로 초기화하고 재귀 함수를 호출해 복호화한 문자열을 리턴한다.
   1. `idx`가 문자열 `s`의 길이보다 작다면 아래를 반복한다.
      1. 현재 문자가 문자라면 현재 문자열에 추가한다.
      2. 숫자라면 `times`를 업데이트한다.
      3. 문자가 `[`라면 재귀 함수를 호출해 괄호 안의 문자열을 복호화하고 현재 문자열에 `times`번 추가하고 `times`를 `0`으로 초기화한다.
      4. 문자가 `]`라면 반복문을 종료한다.
      5. 현재 문자열을 리턴한다.

## Implementation
```java
class Solution {
    private int idx;

    public String decodeString(String s) {
        idx = 0;

        return recur(s);
    }

    private String recur(String s) {
        StringBuilder sb = new StringBuilder();
        int times = 0;

        while (idx < s.length()) {
            char c = s.charAt(idx++);

            if (Character.isLetter(c)) {
                sb.append(c);
            } else if (Character.isDigit(c)) {
                times = times * 10 + c - '0';
            } else if (c == '[') {
                String inner = recur(s);
                
                sb.append(inner.repeat(times));
                times = 0;
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
```

## Complexity
`n`은 문자열 `s`의 길이
- Time complexity: O(n)
- Space complexity: O(n)
