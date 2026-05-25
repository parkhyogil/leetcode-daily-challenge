class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        int[] arr = new int[n];
        arr[0] = 1;

        int sum = 1;

        for (int i = minJump, l = 0, r = 0; i < n; i++) {
            if (i - r > minJump) {
                sum += arr[++r];
            }
            if (i - l > maxJump) {
                sum -= arr[l++];
            }

            if (s.charAt(i) == '0' && sum > 0) {
                arr[i] = 1;
            }
        }

        return arr[n - 1] == 1;
    }
}
