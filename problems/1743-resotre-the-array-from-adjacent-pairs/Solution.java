class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;

        Map<Integer, List<Integer>> adjacent = new HashMap<>();

        for (int[] pair : adjacentPairs) {
            int u = pair[0];
            int v = pair[1];

            adjacent.computeIfAbsent(u, (key) -> new ArrayList<>()).add(v);
            adjacent.computeIfAbsent(v, (key) -> new ArrayList<>()).add(u);
        }

        int ele = 1;
        for (int key : adjacent.keySet()) {
            if (adjacent.get(key).size() == 1) {
                ele = key;
                break;
            }
        }

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = ele;

            if (adjacent.get(ele).size() == 1 || adjacent.get(ele).get(1) == res[i - 1]) {
                ele = adjacent.get(ele).get(0);
            } else {
                ele = adjacent.get(ele).get(1);
            }
        }

        return res;
    }
}
