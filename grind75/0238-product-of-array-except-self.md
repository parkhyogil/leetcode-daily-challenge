# [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description/) 

## Intuition
임의의 `product[i]`의 값은 `prefix[i - 1] * suffix[i + 1]`이라 할 수 있다.\
prefix product와 suffix product로 해결할 수 있다.

## Algorithm
1. 결과를 저장할 배열 `res` 선언.
2. prefix product를 저장할 `prefix` 선언.
3. `nums`를 앞에서부터 순회하여 `res[i]`에 `prefix`를 저장하고 `prefix`에 `nums[i]`를 곱해준다.
4. suffix product를 저장할 `suffix` 선언.
5. `nums`를 뒤에서부터 순회하여 `res[i]`에 `suffix`를 곱해주고 `suffix`에 `nums[i]`를 곱해준다.
6. `res` 리턴.

## Implementation
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        int prefix = 1;
        for (int i = 0; i < n; i++) {
            res[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }
}
```

## Complexity
- Time complexity: O(n)\
두번의 반복문으로 소요된 시간. `n`은 `nums`의 길이.

- Space complexity: O(1)\
`prefix`, `suffix`를 저장한 공간.