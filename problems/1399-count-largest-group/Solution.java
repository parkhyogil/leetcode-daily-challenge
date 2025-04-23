class Solution {
    public int countLargestGroup(int n) {
        int[] groupCount = new int[37];

        for (int i = 1; i <= n; i++) {
            groupCount[sumDigits(i)]++;
        }

        int maxSize = 0;
        int count = 0;

        for (int i = 1; i < 37; i++) {
            if (groupCount[i] > maxSize) {
                maxSize = groupCount[i];
                count = 1;
            } else if (groupCount[i] == maxSize) {
                count++;
            }
        }

        return count;
    }

    private int sumDigits(int i) {
        int sum = 0;

        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }

        return sum;
    }
}
