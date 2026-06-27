class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.merge(x, 1, Integer::sum);
        }

        int one = freq.getOrDefault(1, 0);

        int result = one % 2 == 1 ? one : one - 1;

        freq.remove(1);

        for (int x : freq.keySet()) {
            int len = 1;

            while (x > 0) {
                int sq = (int) Math.sqrt(x);

                if (sq * sq == x && freq.getOrDefault(sq, 0) > 1) {
                    len += 2;
                    x = sq;
                } else {
                    break;
                }
            }

            result = Math.max(result, len);
        }

        return result;
    }
}
