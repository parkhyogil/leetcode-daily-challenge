class Solution {
    int[] root;

    public int minSwaps(int[] nums) {
        int n = nums.length;

        root = new int[n];

        int[] ds = new int[n];
        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;

            arr[i] = i;
            int x = nums[i];

            while (x > 0) {
                ds[i] += x % 10;
                x /= 10;
            }
        }

        Arrays.sort(arr, (a, b) -> ds[a] == ds[b] ? nums[a] - nums[b] : ds[a] - ds[b]);

        for (int i = 0; i < n; i++) {
            union(i, arr[i]);
        }

        int result = n;

        for (int i = 0; i < n; i++) {
            if (i == find(i)) {
                result--;
            }
        }

        return result;
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            root[b] = a;
        } else {
            root[a] = b;
        }
    }

    int find(int x) {
        return x == root[x] ? x : (root[x] = find(root[x]));
    }
}
