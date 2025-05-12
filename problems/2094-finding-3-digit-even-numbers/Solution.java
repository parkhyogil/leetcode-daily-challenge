class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }

        List<Integer> result = new ArrayList<>();

        recur(0, 0, freq, result);

        return result.stream().mapToInt(i -> i).toArray();
    }

    private void recur(int depth, int num, int[] freq, List<Integer> result) {
        if (depth == 3) {
            if (num >= 100 && num % 2 == 0) {
                result.add(num);
            }
            return;
        }

        for (int d = 0; d < 10; d++) {
            if (freq[d] > 0) {
                freq[d]--;
                recur(depth + 1, num * 10 + d, freq, result);
                freq[d]++;
            }
        }
    }
}
