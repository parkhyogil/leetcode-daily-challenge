class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        
        List<Integer> primeList = getPrimeList();

        int prevNum = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < prevNum) {
                prevNum = nums[i];
                continue;
            }

            int diff = nums[i] - prevNum;

            int j = binarySearch(diff, primeList);

            if (j == primeList.size() || nums[i] - primeList.get(j) <= 0) {
                return false;
            }

            prevNum = nums[i] - primeList.get(j);
        }

        return true;
    }

    int binarySearch(int target, List<Integer> list) {
        int lo = 0;
        int hi = list.size() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (list.get(mid) <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    List<Integer> getPrimeList() {
        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);

        List<Integer> result = new ArrayList<>();
        for (int i = 2; i <= 1000; i++) {
            if (isPrime[i]) {
                result.add(i);

                for (int j = i + i; j <= 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return result;
    }
}
