class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        int[] x = new int[9];
        for (int i = 1; i < 9; i++) {
            x[i] = i;
        }

        for (int l = 2; l < 10; l++) {
            for (int i = 1; i + l - 1 <= 9; i++) {
                x[i] = x[i] * 10 + x[i] % 10 + 1;

                if (x[i] >= low && x[i] <= high) {
                    result.add(x[i]);
                }
            }
        }

        return result;
    }
}
