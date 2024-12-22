class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int m = heights.length;
        int n = queries.length;

        for (int[] query : queries) {
            if (query[0] > query[1]) {
                int tmp = query[0];
                query[0] = query[1];
                query[1] = tmp;
            }
        }

        List<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            indexList.add(i);
        }
        
        indexList.sort((a, b) -> Integer.compare(queries[b][1], queries[a][1]));

        int[] stack = new int[m];
        int stackIndex = m;

        int[] result = new int[n];
        int heightIndex = m - 1;

        for (int i = 0; i < n; i++){
            int queryIndex = indexList.get(i);
            int[] query = queries[queryIndex];

            int a = query[0];
            int b = query[1];

            if (a == b) {
                result[queryIndex] = a;
                continue;
            }

            if (heights[a] < heights[b]) {
                result[queryIndex] = b;
                continue;
            }

            while (heightIndex >= 0 && b < heightIndex) {
                while (stackIndex != m && heights[heightIndex] >= heights[stack[stackIndex]]) {
                    stackIndex++;
                }
                stack[--stackIndex] = heightIndex--;
            }

            result[queryIndex] = binarySearch(Math.max(heights[a], heights[b]), stackIndex, m - 1, stack, heights);
        }

        return result;
    }

    private int binarySearch(int target, int lo, int hi, int[] stack, int[] heights) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (heights[stack[mid]] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo == stack.length ? -1 : stack[lo];
    }
}
