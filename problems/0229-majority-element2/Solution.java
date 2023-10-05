class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int count1 = 0;
        int count2 = 0;
        int element1 = 0;
        int element2 = 0;

        for (int num : nums) {
            if (count1 == 0 && num != element2) {
                count1 = 1;
                element1 = num;
            } else if (count2 == 0 && num != element1) {
                count2 = 1;
                element2 = num;
            } else if (num == element1) {
                count1++;
            } else if (num == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;

        for (int num : nums) {
            if (num == element1) {
                count1++;
            } else if (num ==element2) {
                count2++;
            }
        }

        int target = n / 3;
        List<Integer> res = new ArrayList<>();
        
        if (count1 > target) {
            res.add(element1);
        }
        if (count2 > target) {
            res.add(element2);
        }

        return res;
    }
}
