import java.util.*;

class Solution {
    int[] tree;
    TreeSet<Integer> obstacles;

    public List<Boolean> getResults(int[][] queries) {
        int max = 0;
        for (int[] q : queries) {
            max = Math.max(max, q[1]);
        }

        tree = new int[max * 4];
        obstacles = new TreeSet<>();

        obstacles.add(0);
        obstacles.add(max + 1);

        List<Boolean> result = new ArrayList<>();

        for (int[] q : queries) {
            int x = q[1];
            if (q[0] == 1) {
                int leftObstacle = obstacles.lower(x);
                int rightObstacle = obstacles.higher(x);

                update(1, 1, max, x, x - leftObstacle);
                update(1, 1, max, rightObstacle, rightObstacle - x);

                obstacles.add(x);
            } else {
                result.add(Math.max(query(1, 1, max, x), x - obstacles.lower(x)) >= q[2]);
            }
        }

        return result;
    }

    int query(int i, int l, int r, int qi) {
        if (qi < l) {
            return 0;
        }

        if (r <= qi) {
            return tree[i];
        }

        int m = (l + r) / 2;

        if (qi <= m) {
            return query(i * 2, l, m, qi);
        }

        return Math.max(query(i * 2, l, m, qi), query(i * 2 + 1, m + 1, r, qi));
    }

    int update(int i, int l, int r, int idx, int val) {
        if (idx < l || r < idx) {
            return tree[i];
        }

        if (l == r) {
            return tree[i] = val;
        }

        int m = (l + r) / 2;

        return tree[i] = Math.max(update(i * 2, l, m, idx, val), update(i * 2 + 1, m + 1, r, idx, val));
    }
}
