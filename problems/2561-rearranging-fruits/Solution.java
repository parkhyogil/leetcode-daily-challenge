class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.merge(basket1[i], 1, Integer::sum);
            map.merge(basket2[i], -1, Integer::sum);
        }

        List<int[]> list = new ArrayList<>();
        long minVal = -1;

        for (int key : map.keySet()) {
            int freq = map.get(key);

            if (freq % 2 != 0) {
                return -1;
            }

            if (freq != 0) {
                list.add(new int[]{key, freq});
            } else {
                if (minVal == -1 || minVal > key) {
                    minVal = key;
                }
            }
        }

        list.sort((a, b) -> a[0] - b[0]);

        int m = list.size();

        long result = 0;

        for (int i = 0, j = m - 1, k = m - 1; i < m; i++) {
            int v = list.get(i)[0];
            int f = list.get(i)[1];

            if (f == 0) {
                continue;
            }

            if (f > 0) {
                while (f > 0) {
                    while (list.get(j)[1] >= 0) {
                        j--;
                    }

                    int min = Math.min(f, -list.get(j)[1]);

                    f -= min;
                    list.get(j)[1] += min;

                    long cost = (long) v * min / 2;
                    if (minVal != -1) {
                        cost = Math.min(cost, minVal * min);
                    }

                    result += cost;
                }
            } else {
                while (f < 0) {
                    while (list.get(k)[1] <= 0) {
                        k--;
                    }

                    int min = Math.min(-f, list.get(k)[1]);

                    f += min;
                    list.get(k)[1] -= min;

                    long cost = (long) v * min / 2;
                    if (minVal != -1) {
                        cost = Math.min(cost, minVal * min);
                    }

                    result += cost;
                }
            }

            if (minVal == -1 || minVal > v) {
                minVal = v;
            }
        }

        return result;
    }
}
