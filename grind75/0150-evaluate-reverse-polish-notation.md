# [150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/description/)

## Intuition
스택을 이용해 피연산자일 경우 스택에 저장, 연산자일 경우 스택에서 두 값을 꺼내 연산 후 저장해서 답을 찾는다.

## Algorithm
1. 피연산자를 저장할 `stack`을 선언.
2. `tokens`를 순회하며 `token`이 피연산자일 경우 스택에 저장, 연산자일 경우 스택에서 두 값을 꺼내 연산 후 저장.
3. 순회를 마치면 `stack`에 하나의 값이 있고 그것을 리턴.

## Implementation
```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop()); 
                    break;
                case "/":
                    stack.push((int) (1.0 / stack.pop() * stack.pop()));
                    break;
                default: 
                    stack.push(Integer.parseInt(token));

            }
        }

        return stack.pop();
    }
}
```

## Complexity
- Time complexity: O(n)\
`tokens`를 순회한다. `n`은 `tokens`의 길이.

- Space complexity: O(n)\
`stack`에서 사용한 공간. `n`은 `tokens`의 길이.
