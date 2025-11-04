class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;

        int[] result = new int[n - k + 1];

        for (int i = 0; i + k <= n; i++) {
            result[i] = getXSum(i, i + k, x, nums);
        }

        return result;
    }

    int getXSum(int i, int j, int x, int[] nums) {
        int sum = 0;

        int[] freq = new int[51];
        List<Integer> list = new ArrayList<>();

        while (i < j) {
            if (freq[nums[i]] == 0) {
                list.add(nums[i]);
            }
            freq[nums[i++]]++;
        }

        list.sort((a, b) -> freq[a] == freq[b] ? b - a : freq[b] - freq[a]);

        for (int k = 0; k < x && k < list.size(); k++) {
            int v = list.get(k);
            sum += v * freq[v];
        }

        return sum;
    }
}
