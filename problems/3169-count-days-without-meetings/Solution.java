class Solution {
    public int countDays(int days, int[][] meetings) {
        int result = 0;

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int prevEnd = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            if (prevEnd < start) {
                result += start - prevEnd - 1;
            }
            prevEnd = Math.max(prevEnd, end);
        }

        if (days > prevEnd) {
            result += days - prevEnd;
        }

        return result;
    }
}
