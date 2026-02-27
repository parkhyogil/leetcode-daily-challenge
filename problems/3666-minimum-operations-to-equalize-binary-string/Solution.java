class Solution {
    int[] root;

    public int minOperations(String s, int k) {
        int n = s.length();

        int one = 0;

        for (char c : s.toCharArray()) {
            one += c - '0';
        }

        if (one == n) {
            return 0;
        }

        root = new int[n + 3];
        for (int i = 0; i <= n + 2; i++) {
            root[i] = i;
        }

        int result = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(one);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int curr = queue.poll();

                if (curr == n) {
                    return result;
                }

                int i = curr + k - Math.min(curr, k) * 2;
                if (i == root[i]) {
                    queue.offer(i);
                }
                
                int j = curr + k - Math.max(0, k - n + curr) * 2;

                while ((i = union(i, i + 2)) <= j) {
                    queue.offer(i);
                }
            }
            result++;
        }

        return -1;
    }

    int findRoot(int child) {
        if (child == root[child]) {
            return child;
        }
        return root[child] = findRoot(root[child]);
    }

    int union(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);

        if (a < b) {
            root[a] = b;
        } else {
            root[b] = a;
        }

        return root[a];
    }
}
