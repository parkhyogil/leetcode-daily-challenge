# [32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)

## Intuition
배열의 앞에서부터 진행하며, 문자가 `)`인 경우 역순으로 진행해온 문자를 비교한다. 
이때 적합한 자료구조로 `Stack`을 사용한다. 
스택은 인덱스를 관리하며, 현재 문자가 `)`일 때 스택의 마지막 인덱스에 있는 문자를 확인한다. 
만약 그 문자가 `(`라면 쌍이 맞으므로 스택에서 제거한다. 이때 유효한 괄호 쌍의 길이를 갱신할 수 있다.

`(`를 제거한 후 스택에 남아 있는 마지막 인덱스는 유효하지 않은 괄호 쌍의 마지막 인덱스를 의미한다. 현재 인덱스와 스택에 마지막으로 남아 있는 인덱스의 차이가 유효한 괄호 쌍의 길이가 된다.

문자열 `")()())()"`가 주어졌을 때 진행 과정은 아래와 같다.
```
i = 0;      stack = [0];         maxLength = 0;
i = 1;      stack = [0,1];       maxLength = 0;
i = 2;      stack = [0];         maxLength = max(2 - 0, maxLength);
i = 3;      stack = [0,3];       maxLength = 2;
i = 4;      stack = [0];         maxLength = max(4 - 0, maxLength);
i = 5;      stack = [0,5];       maxLength = 4;
i = 6;      stack = [0,5,6];     maxLength = 4;
i = 7;      stack = [0,5];       maxLength = max(7 - 5, maxLength);
```

스택을 이용해 `O(n)`의 시간 복잡도로 문제를 효율적으로 해결할 수 있다.

## Implementation
```java
class Solution {
    public int longestValidParentheses(String s) {
        int length = s.length();

        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();

                maxLength = Math.max(maxLength, i - (stack.isEmpty() ? -1 : stack.peek()));
            } else {
                stack.push(i);
            }
        }

        return maxLength;
    }
}
```

## Complexity
`n`은 문자열 `s`의 길이
- Time complexity: O(n)
- Space complexity: O(n)
