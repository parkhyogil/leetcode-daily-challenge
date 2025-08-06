class Solution {
    int[] tree;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        int[][] pairs = new int[n][];

        for (int i = 0; i < n; i++) {
            pairs[i] = new int[] {baskets[i], i};
        }

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        tree = new int[n * 4];
        buildTree(1, 0, n - 1, pairs);

        int placed = 0;

        for (int i = 0; i < n; i++) {
            if (fruits[i] > pairs[n - 1][0]) {
                continue;
            }

            int l = binarySearch(fruits[i], pairs);

            int placedIndex = query(1, 0, n - 1, l, n - 1, pairs);

            if(pairs[placedIndex][1] < n) {
                update(1, 0, n - 1, placedIndex, n, pairs);
                placed++;
            }
        }

        return n - placed;
    }

    int binarySearch(int t, int[][] arr) {
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid][0] < t) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    int query(int i, int l, int r, int qL, int qR, int[][] pairs) {
        if (qR < l || r < qL) {
            return -1;
        }

        if (qL <= l && r <= qR) {
            return tree[i];
        }

        int m = (l + r) / 2;

        int left = query(i * 2, l, m, qL, qR, pairs);
        int right = query(i * 2 + 1, m + 1, r, qL, qR, pairs);

        if (left == -1) {
            return right;
        } else if (right == -1) {
            return left;
        } else {
            return pairs[left][1] < pairs[right][1] ? left : right;
        }
    }

    int update(int i, int l, int r, int idx, int val, int[][] pairs) {
        if (idx < l || r < idx) {
            return tree[i];
        }

        if (l == r) {
            pairs[l][1] = val;
            return tree[i] = l;
        }

        int m = (l + r) / 2;

        int left = update(i * 2, l, m, idx, val, pairs);
        int right = update(i * 2 + 1, m + 1, r, idx, val, pairs);

        return tree[i] = pairs[left][1] < pairs[right][1] ? left : right;
    }

    int buildTree(int i, int l, int r, int[][] pairs) {
        if (l == r) {
            return tree[i] = l;
        }

        int m = (l + r) / 2;

        int left = buildTree(i * 2, l, m, pairs);
        int right = buildTree(i * 2 + 1, m + 1, r, pairs);

        return tree[i] = pairs[left][1] < pairs[right][1] ? left : right;
    }
}
