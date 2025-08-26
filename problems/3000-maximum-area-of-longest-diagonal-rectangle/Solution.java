class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = 0;
        int result = 0;

        for (int[] dimension : dimensions) {
            int l = dimension[0], w = dimension[1];

            int diagonal = l * l + w * w;
            int area = l * w;

            if (maxDiagonal < diagonal || (maxDiagonal == diagonal && result < area)) {
                result = area;
                maxDiagonal = diagonal;
            }
        }

        return result;
    }
}
