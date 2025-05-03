class Solution {
    public String nearestPalindromic(String n) {
        int length = n.length();

        long num = Long.parseLong(n);

        long min = (long) Math.pow(10, length - 1) - 1;
        long max = (long) Math.pow(10, length) + 1;

        char[] array = n.toCharArray();

        for (int i = 0; i < length / 2; i++) {
            array[length - 1 - i] = array[i];
        }

        long mid = Long.parseLong(String.valueOf(array));

        for (int i = length / 2; i < length; i++) {
            array[i]++;

            if (array[i] > '9') {
                array[i] = '0';
            } else {
                break;
            }
        }

        for (int i = length / 2; i < length; i++) {
            array[length - 1 - i] = array[i];
        }
        long high = Long.parseLong(String.valueOf(array));

        array = String.valueOf(mid).toCharArray();

        for (int i = length / 2; i < length; i++) {
            array[i]--;

            if (array[i] < '0') {
                array[i] = '9';
            } else {
                break;
            }
        }

        for (int i = length / 2; i < length; i++) {
            array[length - 1 - i] = array[i];
        }
        long low = Long.parseLong(String.valueOf(array));

        long result = max;

        if (Math.abs(num - min) < Math.abs(result - num)) {
            result = min;
        }

        if (Math.abs(num - low) < Math.abs(result - num)) {
            result = low;
        }

        if (num != mid && Math.abs(num - mid) < Math.abs(result - num)) {
            result = mid;
        }

        if (Math.abs(high - num) < Math.abs(result - num)) {
            result = high;
        }
        
        return String.valueOf(result);
    }
}
