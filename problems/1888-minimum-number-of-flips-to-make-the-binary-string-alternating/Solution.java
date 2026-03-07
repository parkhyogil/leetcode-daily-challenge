class Solution {
    public int minFlips(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int[][] suff = new int[n + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            suff[i][0] = suff[i + 1][1];
            suff[i][1] = suff[i + 1][0];

            suff[i][arr[i] - '0']++;
        }

        int result = n;

        int[] pref = new int[2];

        for (int l = 0, r = 0; r < n; r++) {
            while (l < r && arr[r - 1] == arr[r]) {
                if (l % 2 == 0) {
                    pref[arr[l] - '0']++;
                } else {
                    pref[(arr[l] - '0') ^ 1]++;
                }
                l++;
            }
            
            int len = n - l;
            int last = arr[l] - '0';
            if (len % 2 == 0) {
                last = last ^ 1;
            }

            int sum = suff[r + 1][arr[r] - '0'] + pref[last];

            result = Math.min(result, sum);
        }

        return result;
    }
}
