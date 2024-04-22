# [39. Combination Sum](https://leetcode.com/problems/combination-sum/description/)

## Intuition
백트래킹 기법으로 합을 초과하는 경우 가지를 처내면서 조건에 맞는 조합을 찾는다.

## Algorithm
재귀함수 종료 조건은 아래와 같다.
- `target`이 0일 경우 `comb`를 `res`에 저장.
- `target`이 0보다 작을 경우 되돌아간다.

종료 조건에 맞지 않다면 `comb`에 후보를 추가한 뒤 재귀함수를 호출해 위의 조건을 확인하고 빠져나오면서 후보를 제거한다. 

## Implementation
```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        recur(0, candidates, target, new ArrayList<>(), res);
        return res;
    }

    private void recur(int idx, int[] candidates, int target, List<Integer> comb, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        
        if (target < 0 || idx == candidates.length) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            comb.add(candidates[i]);
            recur(i, candidates, target - candidates[i], comb, res);
            comb.remove(comb.size() - 1);
        }
    }
}
```

## Complexity
- Time complexity: O(n^m)\
`n`개의 후보들을 조합해서 합이 `m`이 될 때까지 재귀함수를 호출.
- Space complexity: O(m)\
재귀함수의 깊이와 `comb`에서 사용한 공간. `m`은 `target`의 값.
