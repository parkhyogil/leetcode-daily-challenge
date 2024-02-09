class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        List<Integer>[] arr = new ArrayList[n];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();

            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && arr[j].size() > arr[i].size()) {
                    arr[i] = new ArrayList<>(arr[j]);
                }
            }

            arr[i].add(nums[i]);

            if (arr[i].size() > res.size()) {
                res = arr[i];
            }
        }

        return res;
    }
}
