class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] count = new int[n];
        int basket = 0;

        int res = 0;
        for (int left = 0, right = 0; right < n; right++) {
            int fruit = fruits[right];
            if (count[fruit] == 0) {
                basket++;
            }
            count[fruit]++;

            while (basket > 2) {
                fruit = fruits[left];
                count[fruit]--;
                if (count[fruit] == 0) {
                    basket--;
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
