# [78. Subsets](https://leetcode.com/problems/subsets/)

## Intuition
재귀함수로 `nums`의 요소를 선택하거나 선택하지 않는 경우를 호출해 부분집합을 완성한다.

## Algorithm
1. 결과를 저장할 `res` 선언.
2. 부분집합을 만들 재귀함수 호출.
   1. 현재까지의 부분집합 `subset`을 `res`에 저장.
   2. `idx`부터 `nums`를 순회.
   3. `nums[i]`를 `subset`에 추가하고 다음 재귀를 `i + 1`부터 호출.
   3. `subset`에서 `nums[i]`를 제거.
3. `res` 리턴.

## Implementation
```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        recur(0, nums, new ArrayList<>(), res);

        return res;
    }

    private void recur(int idx, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        res.add(new ArrayList<>(subset));
        
        for (int i = idx; i < nums.length; i++) {
            subset.add(nums[i]);
            recur(i + 1, nums, subset, res);
            subset.remove(subset.size() - 1);
        }
    }
}
```

## Complexity
`n`은 `nums`의 길이.
- Time complexity: O(2^n * n)\
`n`개의 요소를 선택하거나 선택하지 않아서 만들수 있는 부분집합의 수는 `2^n`개이고, 조합을 `res`에 저장할 때 사용한 시간은 `n`.

- Space complexity: O(n)\
결과를 저장하기 위한 공간을 제외하고 `subset`에서 사용한 공간은 `n`, 재귀함수의 깊이는 최대 `n`.
