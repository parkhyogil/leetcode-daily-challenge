class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> productCountMap = new HashMap<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int p = nums[i] * nums[j];

                if (productCountMap.containsKey(p)) {
                    result += productCountMap.get(p) * 8;
                }

                productCountMap.merge(p, 1, Integer::sum);
            }
        }

        return result;
    }
}
