# [139. Word Break](https://leetcode.com/problems/word-break/description/)

## Algorithm
1. 재귀함수로 모든 `memo[i]`의 상태를 만든다.
   - `idx == s.length()`라면 `word`의 조합으로 `s`를 만들 수 있다는 뜻이므로 `true` 리턴.
   - `memo[idx] != 0`라면 한번 방문했던 상태이므로 `memo[idx]` 리턴.
   - `wordDict`를 순회하여 `word`가 `s`의 `idx`부터 시작과 같다면 다음 재귀로 진행이 가능. 다음 재귀에서 `true`를 리턴한다면 현재 재귀단계에서도 `true`를 리턴.
   - `true`를 리턴하지 못했다면 `false` 리턴.
2. `memo[0]`을 리턴.


## Implementation
```java
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        int[] memo = new int[n];

        return recur(0, s, wordDict, memo);
    }

    private boolean recur(int idx, String s, List<String> wordDict, int[] memo) {
        if (idx == s.length()) {
            return true;
        }

        if (memo[idx] != 0) {
            return memo[idx] == 1;
        }

        for (String word : wordDict) {
            if (s.startsWith(word, idx) && recur(idx + word.length(), s, wordDict, memo)) {
                memo[idx] = 1;
                return true;
            }
        }

        memo[idx] = -1;
        return false;
    }
}
```

## Complexity
`n`은 `s`의 길이, `m`은 `wordDict`의 길이, `k`는 `wordDict` 안에 있는 단어의 최대 길이.
- Time complexity: O(nmk)\
`memo`의 상태는 `n`개 존재하고 하나의 상태에서 `wordDict` 안에 있는 모든 `word`의 문자를 확인한다.

- Space complexity: O(n)\
`memo`와 재귀함수 콜스택에서 사용한 공간.