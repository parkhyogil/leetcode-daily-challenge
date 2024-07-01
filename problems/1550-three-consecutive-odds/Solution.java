class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;

        for (int l = 0, r = 0; r < n; r++) {
            if (arr[r] % 2 == 0) {
                l = r + 1;
            } else if (r - l + 1 == 3) {
                return true;
            }
        }
      
        return false;
    }
}
