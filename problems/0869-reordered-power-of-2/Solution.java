class Solution {
    public boolean reorderedPowerOf2(int n) {
        int len = (int) Math.log10(n);

        int[] freq = new int[10];

        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
        }

        for (int i = 0; i < 31; i++) {
            int x = 1 << i;

            if (len == (int) Math.log10(x)) {
                boolean result = true;
                int[] freq2 = new int[10];

                while (x > 0) {
                    int d = x % 10;
                    freq2[d]++;

                    if (freq[d] < freq2[d]) {
                        result = false;
                        break;
                    }
                    
                    x/= 10;
                }

                if (result) {
                    return true;
                }
            }
        }

        return false;
    }
}
