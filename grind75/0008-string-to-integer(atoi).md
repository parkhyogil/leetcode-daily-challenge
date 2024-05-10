# [8. String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/)

## Algorithm
1. `idx`에 인덱스 위치를 저장.
2. 공백이 아닌 문자가 나올 때까지 `idx` 증가.
3. `s` 전체가 공백이라면 `0` 리턴.
4. 공백을 제거한 뒤 첫 문자가 `-` 라면 `sign`은 `-1`, 첫 문자가 `+`이거나 숫자라면 `1`.
5. `res`에 누적된 정수 값을 저장.
6. `idx`가 가리키는 문자가 숫자일 때까지 `res`를 업데이트하고 `idx` 증가.
7. `res`가 정수값을 오버플로우 한다면 부호값에 따라 `Integer.MAX_VALUE`,`Integer.MIN_VALUE`를 리턴.
8. `res`에 `sign`을 적용해 리턴.

## Implementation
```java
class Solution {
    public int myAtoi(String s) {
        int n = s.length();

        int idx = 0;

        while (idx < n && s.charAt(idx) == ' ') {
            idx++;
        }

        if (idx == n) {
            return 0;
        }

        int sign = 1;

        if (s.charAt(idx) == '-') {
            sign = -1;
            idx++;
        } else if (s.charAt(idx) == '+') {
            idx++;
        }

        int res = 0;

        while (idx < n && Character.isDigit(s.charAt(idx))) {
            int digit = s.charAt(idx) - '0';

            if ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            idx++;
        }

        return res * sign;
    }
}
```

## Complexity
`n`은 `s`의 길이.
- Time complexity: O(n)\
문자열 `s`를 한번 순회.
- Space complexity: O(1)

