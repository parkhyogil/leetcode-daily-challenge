class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        int result = n;

        for (int i = 0; i < n; i++) {
            int r = reverse(nums[i]);

            if (map.containsKey(nums[i])) {
                result = Math.min(result, i - map.get(nums[i]));
            }

            map.put(r, i);
        }

        return result < n ? result : -1;
    }

    int reverse(int x) {
        int result = 0;

        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        return result;
    }
}
