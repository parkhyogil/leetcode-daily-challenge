class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (letters[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return letters[lo % n];
    }
}
