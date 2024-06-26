# [438. Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/)

## Intuition
슬라이딩 윈도우 기법으로 해결한다.\
오른쪽 포인터에 해당하는 문자 개수를 줄이면서 윈도우를 오른쪽으로 확장해 나간다. 
만약 개수가 0보다 작다면 왼쪽 포인터에 해당하는 문자 개수를 늘려가면서 오른쪽 문자의 개수가 0이 될 때까지 윈도우를 축소한다.\
윈도우의 길이가 목표 문자열의 길이와 같다면 아나그램을 찾은 것이다.

## Algorithm
1. 변수들을 초기화한다.
   - `m` : 문자열 `s`의 길이.
   - `n` : 문자열 `p`의 길이.
   - `freq` : 문자열 `p`의 문자들의 개수를 저장할 배열.
   - `res` : 결과를 저장할 리스트.
2. 문자열 `p`를 한번 순회해 문자들의 개수를 `freq`에 저장한다.
3. `l`은 왼쪽 포인터, `r`은 오른쪽 포인터, 문자열 `s`를 순회한다.
   1. `r`에 해당하는 문자 개수를 감소시킨다.
   2. `r`에 해당하는 문자 개수가 0보다 작다면 0이 될 때까지 `l`에 해당하는 문자 개수를 증가시키며 윈도우를 축소한다.
   3. 현재 윈도우의 길이가 목표 문자열의 길이와 같다면 `res`에 아나그램의 시작 인덱스인 `l`을 저장한다.
4. `res`를 리턴한다.

## Implementation
```java
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();

        int[] freq = new int[26];
        
        for (char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Integer> res = new ArrayList<>();

        for (int l = 0, r = 0; r < m; r++) {
            freq[s.charAt(r) - 'a']--;

            while (freq[s.charAt(r) - 'a'] < 0) {
                freq[s.charAt(l) - 'a']++;
                l++;
            }   

            if (r - l + 1 == n) {
                res.add(l);
            }
        }

        return res;
    }
}
```

## Complexity
`m`은 `s`의 길이, `n`은 `p`의 길이.
- Time complexity: O(m + n)\
두 문자열을 한번씩 순회한다.

- Space complexity: O(1)\
결과를 제외하고 상수 공간을 사용한다. 
