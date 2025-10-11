class Solution {
    public long maximumTotalDamage(int[] power) {
        int n = power.length;

        Arrays.sort(power);

        List<Integer> powers = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (power[i] > prev) {
                prev = power[i];

                powers.add(power[i]);
                count.add(1);
            } else {
                count.set(count.size() - 1, count.get(count.size() - 1) + 1);
            }
        }

        long[] cache = new long[powers.size()];
        Arrays.fill(cache, -1);

        return recur(0, powers, count, cache);
    }

    long recur(int i, List<Integer> powers, List<Integer> count, long[] cache) {
        if (i == powers.size()) {
            return 0;
        }

        if (cache[i] > -1) {
            return cache[i];
        }

        long result = recur(i + 1, powers, count, cache);

        int j = i + 1;
        while (j < powers.size() && powers.get(j) - powers.get(i) <= 2) {
            j++;
        }

        result = Math.max(result, (long) powers.get(i) * count.get(i) + recur(j, powers, count, cache));

        return cache[i] = result;
    }
}
