class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n];
        int idx = -1;

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            int gcd;
            while (idx > -1 && (gcd = getGcd(num, arr[idx])) > 1) {
                num = (int) ((long) num * arr[idx] / gcd);
                idx--;
            }

            arr[++idx] = num;
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= idx; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }
}
