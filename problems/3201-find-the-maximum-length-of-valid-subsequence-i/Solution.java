class Solution {
    public int maximumLength(int[] nums) {
        int odd = 0;
        int even = 0;

        int endEven = 0;
        int endOdd = 0;

        for (int num : nums) { 
            if (num % 2 == 0) {
                even++;

                endEven = Math.max(endEven, endOdd + 1);
            } else {
                odd++;

                endOdd = Math.max(endOdd, endEven + 1);
            }   
        }

        return Math.max(Math.max(odd, even), Math.max(endEven, endOdd));
    }
}
