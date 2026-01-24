class Solution {
    public int minPairSum(int[] nums) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] freq = new int[max + 1];

        for (int num : nums) {
            freq[num]++;
        }

        int result = 0;

        for (int l = 1, r = max; l <= r; ) {
            if (freq[l] == 0) {
                l++;
                continue;
            }

            if (freq[r] == 0) {
                r--;
                continue;
            }

            int f = Math.min(freq[l], freq[r]);
            if (l == r) {
                f = f / 2;
            }
            
            freq[l] -= f;
            freq[r] -= f;

            result = Math.max(result, l + r);
        }

        return result;
    }
}
