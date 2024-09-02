class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;

        int sum = 0;

        for (int num : chalk) {
            sum += num;
            
            if (sum > k) {
                break;
            }
        }

        k %= sum;

        for (int i = 0; i < n; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }

        return -1;
    }
}
