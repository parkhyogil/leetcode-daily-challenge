class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;

        int result = Math.min(
            Math.min(countSwaps(tops[0], tops, bottoms), countSwaps(bottoms[0], tops, bottoms)), 
            Math.min(countSwaps(tops[0], bottoms, tops), countSwaps(bottoms[0], bottoms, tops))
        );

        return result > n ? -1 : result;
    }

    private int countSwaps(int target, int[] a, int[] b) {
        int result = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != target && b[i] != target) {
                return a.length + 1;
            } else if (a[i] != target && b[i] == target) {
                result++;
            }
        }

        return result;
    }
}
