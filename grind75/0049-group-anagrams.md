# [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)

## Intuition
서로 다른 문자열을 정렬해서 같은 문자열이 나온다면 두 문자열은 아나그램이다.
정렬한 문자열을 키로 사용해 주어준 문자열을 그룹화한다.

## Algorithm
1. 정렬된 문자열을 키로 사용하고, 그룹화한 문자열이 저장된 리스트를 값으로 사용하는 해시맵 `map`을 초기화한다.
2. 배열 `strs`를 순회한다. 주어진 문자열을 정렬해 키를 만들고, 해당 리스트에 문자열을 저장한다.
3. `map`의 값을 리스트에 저장하고 리턴한다.

## Implementation
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            map.computeIfAbsent(getKey(str), k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String getKey(String str) {
        char[] arr = str.toCharArray();

        Arrays.sort(arr);

        return String.valueOf(arr);
    }
}
```

## Complexity
`n`은 배열 `strs`의 길이, `m`은 문자열 `str`의 최대 길이.
- Time complexity: O(n * mlogm)
- Space complexity: O(n * m)
