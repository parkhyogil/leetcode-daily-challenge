class Solution {
    public int numRabbits(int[] answers) {
        int[] count = new int[1000];

        int result = 0;

        for (int ans : answers) {
            if (count[ans] == 0) {
                result += 1 + ans;
                count[ans] = -ans;
            } else {
                count[ans]++;
            }
        }

        return result;
    }
}
