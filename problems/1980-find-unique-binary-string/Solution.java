class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(nums[i], 2));
        }

        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                char[] arr = new char[n];
                int x = i;
                
                for (int j = n - 1; j >= 0; j--) {
                    arr[j] = (char) ('0' + x % 2);
                    x /= 2;
                }

                return String.valueOf(arr);
            }
        }

        return "";
    }
}
