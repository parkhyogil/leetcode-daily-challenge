class Solution {
    public int numRescueBoats(int[] people, int limit) {
        sort(people);

        int l = 0;
        int r = people.length - 1;

        int res = 0;
        while (l <= r) {
            if (l == r || people[l] + people[r] > limit) {
                r--;
            } else {
                l++;
                r--;
            }
            res++;
        }
        return res;
    }

    private void sort(int[] nums) {
        int[] count = new int[30001];
        for (int num : nums) {
            count[num]++;
        }

        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            while (count[min] == 0) {
                min++;
            }
            nums[i] = min;
            count[min]--;
        }
    }
}
