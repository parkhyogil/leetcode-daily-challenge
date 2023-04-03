class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;

        int[] count = new int[limit + 1];
        for (int p : people) {
            count[p]++;
        }

        int res = 0;
        
        int min = 1;
        int max = limit;

        while (min < max) {
            if (count[max] == 0) {
                max--;
            } else if (count[min] == 0) {
                min++;
            } else if (min + max <= limit) {
                int saved = Math.min(count[min], count[max]);
                res += saved;
                count[min] -= saved;
                count[max] -= saved;
            } else {
                res += count[max];
                count[max] = 0;
            }
        }
        
        if (min * 2 > limit) {
            res += count[min];
        } else {
            res += (count[min] + 1) / 2;
        }
        return res;
    }
}
