class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;

        for (char c : s.toCharArray()) {
            int intValue = (int) (c - 'a' + 1);

            sum += transform(intValue);
        }
    
        for (int i = 0; i < k - 1; i++) {
            sum = transform(sum);
        }

        return sum;
    }

    private int transform(int value) {
        int result = 0;

        while (value > 0) {
            result += value % 10;
            value /= 10;
        }

        return result;
    }
}
