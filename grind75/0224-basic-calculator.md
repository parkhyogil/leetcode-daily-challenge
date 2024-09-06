# [224. Basic Calculator](https://leetcode.com/problems/basic-calculator/)

## Intuition
표현식을 평가할 때 5가지 경우의 수가 있다.

1. `0 ~ 9` : 이전 숫자에 이어 붙여 계산한다.
2. `+` : 이전 부호와 지금까지 계산한 숫자를 결과에 반영하고 부호를 `+`로 설정하고 숫자를 `0`으로 초기화한다.
3. `-` : `+`와 같은 동작을 하지만, 부호를 `-`로 설정한다.
4. `(` : 재귀적으로 함수를 호출해 괄호 안의 내용을 계산하고 부호와 결과에 반영한다.
5. `)` : 재귀함수의 종료 조건으로, 반복문을 빠져나간다.

마지막으로, 반복문을 빠져나올 때 남은 마지막 부호와 숫자를 결과에 반영한다.

## Implementation
```java
class Solution {
    private int n, index;
    private char[] chars;

    public int calculate(String s) {
        n = s.length();
        index = 0;
        chars = s.toCharArray();

        return calculateRecursively();
    }

    private int calculateRecursively() {
        int result = 0;

        int sign = 1;
        int num = 0;

        while (index < n) {
            char c = chars[index++];

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                result += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                result += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                result += sign * calculateRecursively();
            } else if (c == ')') {
                break;
            }
        }

        result += sign * num;

        return result;
    }
}
```

## Complexity
`n`은 문자열 `s`의 길이
- Time complexity: O(n)
- Space complexity: O(n)
