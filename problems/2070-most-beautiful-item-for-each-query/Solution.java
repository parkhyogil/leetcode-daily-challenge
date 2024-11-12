class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int m = queries.length;

        Arrays.sort(items, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));

        List<int[]> itemList = new ArrayList<>();
        int prevMaxBeauty = 0;

        for (int[] item : items) {
            if (item[1] > prevMaxBeauty) {
                itemList.add(item);
                prevMaxBeauty = item[1];
            }
        }

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            result[i] = binarySearch(queries[i], itemList);
        }

        return result;
    }

    int binarySearch(int target, List<int[]> itemList) {
        int lo = 0;
        int hi = itemList.size() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (itemList.get(mid)[0] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi < 0 ? 0 : itemList.get(hi)[1];
    }
}
