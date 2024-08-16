# [179. Largest Number](https://leetcode.com/problems/largest-number/)

## Intuition
두 숫자를 이어 붙일 때, 더 큰 숫자가 되는 쪽을 배열의 앞으로 옮긴다. 

## Algorithm
1. 숫자 배열 `nums`로 문자열 배열 `strs`을 만든다.
2. `strs`를 정렬한다. `Comparator`를 두 숫자를 이어 붙일 때, 더 큰 숫자가 되는 쪽으로 정렬되도록 한다.
3. 정렬된 `strs`를 이어붙여 반환한다.

## Implementation
```java
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a, b) -> {
            int len1 = a.length();
            int len2 = b.length();

            int i = 0;

            while (i < len1 + len2) {
                char c1 = i < len1 ? a.charAt(i) : b.charAt(i % len1);
                char c2 = i < len2 ? b.charAt(i) : a.charAt(i % len2);

                if (c1 == c2) {
                    i++;
                } else {
                    return c1 > c2 ? -1 : 1;
                }
            }

            return 0;
        });

        if (strs[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }
}
```

## Complexity
`n`은 배열 `nums`의 길이
- Time complexity: O(nlogn)
- Space complexity: O(n)
