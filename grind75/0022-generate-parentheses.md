# [22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/description/)

## Intuition
백트래킹 기법으로 유효한 괄호 조합을 만든다.\
열림 괄호가 원하는 괄호의 쌍보다 많거나 닫힘 괄호가 열림 괄호보다 많다면 유효하지 않은 조합이다.

## Algorithm
1. `gerenateParenthesis` 메소드 : `n`쌍의 유요한 괄호 문자열 리스트를 찾는다.
   1. `List<Integer> result` 괄호 문자열을 저장할 결과 리스트를 초기화한다.
   2. `generateParenthesesRecursively`메소드로 문자열을 만든다.
   3. `result`를 리턴한다.
2. `generateParenthesesRecursively` 메소드 : 재귀적으로 `n` 쌍의 유효한 괄호 문자열을 만든다. 유효하지 않다면 재귀함수를 종료해 다음 조합을 찾는다.
   1. 열림 괄호 `open`이 원하는 괄호 쌍 `n`보다 많거나 닫힘 괄호 `close`가 열림 괄호 `open`보다 많다면 유요하지 않은 조합으로 재귀함수를 종료한다.
   2. 조합이 완성됐다면 `result`에 현재 조합을 추가하고 재귀함수를 종료한다.
   3. 현재 위치에 열림 괄호를 추가하고 재귀함수를 호출한다.
   4. 닫힘 괄호를 추가하고 재귀함수를 호출한다.

## Implementation
```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generateParenthesesRecursively(0, new char[n * 2], 0, 0, n, result);

        return result;
    }

    private void generateParenthesesRecursively(int index, char[] current, int open, int close, int n, List<String> result) {
        if (open > n || close > open) {
            return;
        }

        if (index == n * 2) {
            result.add(String.valueOf(current));
            return;
        }

        current[index] = '(';
        generateParenthesesRecursively(index + 1, current, open + 1, close, n, result);
        current[index] = ')';
        generateParenthesesRecursively(index + 1, current, open, close + 1, n, result);
    }
}
```

## Complexity
- Time complexity: O(2^n)
- Space complexity: O(n)
