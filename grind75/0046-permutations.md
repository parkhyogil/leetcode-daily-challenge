# [46. Permutations](https://leetcode.com/problems/permutations/)

## Intuition
재귀함수의 깊이는 순열의 자리가 된다. 
순열의 자리에 들어갈 숫자를 하나 고르고 다음 자리로 넘어가 사용할 수 있는 숫자를 고르면서 모든 숫자를 다 사용했을 때 순열을 결과에 저장하고 재귀함수를 빠져나온다. 

## Algorithm
1. 순열에 모든 숫자를 사용했다면 `res`에 `permu`를 저장하고 재귀함수 종료.
2. 사용하지 않은 숫자를 찾아 순열에 추가하고 재귀함수를 호출해 다음 자리로 넘어간다.

## Implementation
```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recur(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    private void recur(int[] nums, boolean[] use, List<Integer> permu, List<List<Integer>> res) {
        if (permu.size() == nums.length) {
            res.add(new ArrayList<>(permu));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (use[i]) {
                continue;
            }
            permu.add(nums[i]);
            use[i] = true;
            recur(nums, use, permu, res);
            permu.remove(permu.size() - 1);
            use[i] = false;
        }
    }
}
```

## Complexity
`n`은 `nums`의 길이.
- Time complexity: O(n!)\
재귀함수의 가지는 `n`개에서 1개로 깊어질수록 줄어든다. 

- Space complexity: O(n)\
결과를 제외하고 사용된 공간은 재귀함수에서 사용한 콜 스택과 `permu`의 공간.