class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;

        boolean[] contains = new boolean[1000];
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) {
                        continue;
                    }

                    int x = digits[i] * 100 + digits[j] * 10 + digits[k];
                    
                    if (x >= 100 && x % 2 == 0 && !contains[x]) {
                        result++;
                        contains[x] = true;
                    }
                }
            }
        }

        return result;
    }
}
