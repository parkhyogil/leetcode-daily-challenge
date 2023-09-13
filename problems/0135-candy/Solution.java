class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] count = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += recur(i, ratings, count);
        }
        return res;
    }

    private int recur(int i, int[] ratings, int[] count) {
        if (count[i] != 0) {
            return count[i];
        }

        int rating = ratings[i];
        int left = i - 1 < 0 ? Integer.MAX_VALUE : ratings[i - 1];
        int right = i + 1 == ratings.length ? Integer.MAX_VALUE : ratings[i + 1];

        if (left < rating && rating > right) {
            return count[i] = Math.max(recur(i - 1, ratings, count), recur(i + 1, ratings, count)) + 1;
        }

        if (left < rating) {
            return count[i] = recur(i - 1, ratings, count) + 1;
        }
        
        if (right < rating) {
            return count[i] = recur(i + 1, ratings, count) + 1;
        }

        return count[i] = 1;
    }
}
