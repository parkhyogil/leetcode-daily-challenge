class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;

        for (int x : costs) {
            max = Math.max(max, x);
        }

        int[] freq = new int[max + 1];
        for (int x : costs) {
            freq[x]++;
        }

        int result = 0;

        for (int i = 1; i <= max && i <= coins; i++) {
            int count = Math.min(freq[i], coins / i);

            result += count;
            coins -= count * i;
        }

        return result;
    }
}
