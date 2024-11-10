class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        int orValue = 0;
        int[] bits = new int[32];
        
        int length = n + 1;

        for (int l = 0, r = 0; r < n; r++) {
            orValue = addBit(orValue, bits, nums[r]);

            while (l <= r && orValue >= k) {
                length = Math.min(length, r - l + 1);
                orValue = removeBit(orValue, bits, nums[l++]);
            }
        }

        return length > n ? -1 : length;
    }

    int addBit(int orValue, int[] bits, int num) {
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & num) > 0) {
                if (bits[i] == 0) {
                    orValue |= 1 << i;
                }
                bits[i]++;
            }
        }

        return orValue;
    }

    int removeBit(int orValue, int[] bits, int num) {
        for (int i = 0; i < 32; i++) {
            if (((1 << i) & num) > 0) {
                bits[i]--;
                if (bits[i] == 0) {
                    orValue -= 1 << i;
                }
            }
        }

        return orValue;
    }
}
