class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        max -= extraCandies;

        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            res.add(candy >= max);
        }
        return res;
    }
}
