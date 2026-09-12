import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        list.sort((a, b) -> intervals.get(a).get(1) - intervals.get(b).get(1));

        long[][] max = new long[n + 1][5];
        int[][][] dp = new int[n + 1][5][];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                dp[i][j] = new int[j];
                Arrays.fill(dp[i][j], n + 1);
            }
        }

        int[] result = new int[0];
        long maxW = 0;

        for (int i = 0; i < n; i++) {
            int l = intervals.get(list.get(i)).get(0);
            int r = intervals.get(list.get(i)).get(1);
            int w = intervals.get(list.get(i)).get(2);

            int j = bs(l, list, intervals);

            for (int k = 1; k <= 4; k++) {
                System.arraycopy(dp[i][k], 0, dp[i + 1][k], 0, k);

                if (max[j + 1][k - 1] + w > max[i][k]) {
                    max[i + 1][k] = max[j + 1][k - 1] + w;
                    System.arraycopy(dp[j + 1][k - 1], 0, dp[i + 1][k], 0, k - 1);
                    dp[i + 1][k][k - 1] = list.get(i);
                    Arrays.sort(dp[i + 1][k]);
                } else if (max[j + 1][k - 1] + w < max[i][k]) {
                    max[i + 1][k] = max[i][k];
                } else {
                    int[] tmp = new int[k];

                    System.arraycopy(dp[j + 1][k - 1], 0, tmp, 0, k - 1);
                    tmp[k - 1] = list.get(i);
                    Arrays.sort(tmp);

                    if (Arrays.compare(tmp, dp[i + 1][k]) < 0) {
                        System.arraycopy(tmp, 0, dp[i + 1][k], 0, k);
                    }
                }
                max[i + 1][k] = Math.max(max[j + 1][k - 1] + w, max[i][k]);

                if (max[i + 1][k] > maxW || (max[i + 1][k] == maxW && Arrays.compare(dp[i + 1][k], result) < 0)) {
                    maxW = max[i + 1][k];
                    result = dp[i + 1][k];
                }
            }
        }

        return result;
    }

    int bs(int t, List<Integer> list, List<List<Integer>> intv) {
        int lo = 0;
        int hi = list.size() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (intv.get(list.get(mid)).get(1) < t) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }
}
