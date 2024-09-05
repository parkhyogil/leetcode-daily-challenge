class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;

        int sum = mean * (m + n);

        for (int roll : rolls) {
            sum -= roll;
        }
        
        if (sum < n || sum > n * 6) {
            return new int[] {};
        }

        int[] result = new int[n];
        int number = sum / n;

        for (int i = 0; i < n; i++) {
            result[i] = number;

            if (i < sum % n) {
                result[i]++;
            }
        }

        return result;
    }
}
