class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> hVals = new ArrayList<>();
        List<Integer> vVals = new ArrayList<>();

        for (int h : hFences) {
            hVals.add(h);
        }
        hVals.add(1);
        hVals.add(m);

        for (int v : vFences) {
            vVals.add(v);
        }
        vVals.add(1);
        vVals.add(n);

        hVals.sort(Integer::compare);
        vVals.sort(Integer::compare);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < hVals.size(); i++) {
            for (int j = i + 1; j < hVals.size(); j++) {
                set.add(hVals.get(j) - hVals.get(i));
            }
        }

        int len = -1;

        for (int i = 0; i < vVals.size(); i++) {
            for (int j = i + 1; j < vVals.size(); j++) {
                if (set.contains(vVals.get(j) - vVals.get(i))) {
                    len = Math.max(len, vVals.get(j) - vVals.get(i));
                }
            }
        }

        return len == -1 ? -1 : (int) ((long) len * len % 1_000_000_007);
    }
}
