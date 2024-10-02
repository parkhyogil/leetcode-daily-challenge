class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;

        if (n == 0) {
            return new int[0];
        }

        Integer[] indexArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexArray[i] = i;
        }

        Arrays.sort(indexArray, (a, b) -> Integer.compare(arr[a], arr[b]));

        int[] rankArray = new int[n];
        rankArray[indexArray[0]] = 1;

        for (int i = 1; i < n; i++) {
            rankArray[indexArray[i]] = rankArray[indexArray[i - 1]];
            if (arr[indexArray[i]] > arr[indexArray[i - 1]]) {
                rankArray[indexArray[i]]++;
            }
        }

        return rankArray;
    }
}
