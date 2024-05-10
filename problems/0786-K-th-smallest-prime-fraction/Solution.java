class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;

        double lo = 0.0;
        double hi = 1.0;

        while (lo <= hi) {
            double mid = (lo + hi) / 2;

            int countSmaller = 0;
            
            int numerator = 1;
            int denominator = arr[n - 1];
            
            int i = 0;
            for (int j = 1; j < n; j++) {
                while (arr[i] <= mid * arr[j]) {
                    i++;
                }

                countSmaller += i;

                if (i > 0 && arr[i - 1] * denominator > numerator * arr[j]) {
                    numerator = arr[i - 1];
                    denominator = arr[j];
                }
            }

            if (countSmaller == k) {
                return new int[] {numerator, denominator};
            }

            if (countSmaller < k) {
                lo = mid;
            } else {
                hi = mid;
            }
        }   

        return new int[] {};
    }
}
