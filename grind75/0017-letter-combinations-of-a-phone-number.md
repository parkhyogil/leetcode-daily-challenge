# [17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/)

## Intuition
백트래킹을 이용해 주어진 문자열과 전화 버튼으로 가능한 모든 조합을 만든다.

## Algorithm
1. 문자열이 비어있는 경우 빈 리스트를 리턴한다.
2. 조합을 저장할 `res`를 선언한다.
3. 재귀함수를 호출한다.
   1. `idx == digits.length()`라면 조합을 완성했으니 완성된 조합을 `res`에 저장하고 재귀함수를 종료한다.
   2. `digits`의 `idx`에 해당하는 숫자의 문자들을 `comb`의 `idx` 자리에 넣고 `idx`를 1 증가시켜 다음 재귀함수를 호출한다.
4. `res`를 리턴한다.

## Implementation
```java
class Solution {
    private char[][] numPad = new char[][] {
        {'a', 'b', 'c'}, {'d', 'e', 'f'},
        {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        
        List<String> res = new ArrayList<>();

        recur(0, digits, new char[digits.length()], res);

        return res;
    }

    private void recur(int idx, String digits, char[] comb, List<String> res) {
        if (idx == digits.length()) {
            res.add(String.valueOf(comb));
            return;
        }

        for (char c : numPad[digits.charAt(idx) - '0' - 2]) {
            comb[idx] = c;
            recur(idx + 1, digits, comb, res);
        }
    }
}
```

## Complexity
`n`은 `digits`의 길이.
- Time complexity: O(n * 4^n)\
버튼 하나 당 최대 4개의 문자를 갖고 `n`번 선택한다. 그리고 완성된 조합을 `res`에 저장하는데 `n`의 시간이 걸린다.

- Space complexity: O(n)\
재귀함수에서 사용한 콜스택 공간과 `comb`에서 사용한 공간.
