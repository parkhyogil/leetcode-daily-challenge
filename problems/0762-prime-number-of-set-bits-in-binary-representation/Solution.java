class Solution {
    public int countPrimeSetBits(int left, int right) {
        boolean[] isPrime = new boolean[20];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i < 20; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 20; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int result = 0;

        for (int i = left; i <= right; i++) {
            if (isPrime[countBits(i)]) {
                result++;
            }
        }

        return result;
    }

    int countBits(int num) {
        num = (num & 0x55555555) + ((num & 0xaaaaaaaa) >> 1);
        num = (num & 0x33333333) + ((num & 0xcccccccc) >> 2);
        num = (num & 0x0f0f0f0f) + ((num & 0xf0f0f0f0) >> 4);
        num = (num & 0x00ff00ff) + ((num & 0xff00ff00) >> 8);
        num = (num & 0x0000ffff) + ((num & 0xffff0000) >> 16);

        return num;
    }
}
