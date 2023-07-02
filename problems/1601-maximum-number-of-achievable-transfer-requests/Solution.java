class Solution {
    public int maximumRequests(int n, int[][] requests) {
        return recur(0, new int[n], requests);
    }

    private int recur(int idx, int[] netChange, int[][] requests) {
        if (idx == requests.length) {
            for (int change : netChange) {
                if (change != 0) {
                    return Integer.MIN_VALUE;
                }
            }
            return 0;
        }

        int res = recur(idx + 1, netChange, requests);
        netChange[requests[idx][0]]--;
        netChange[requests[idx][1]]++;
        res = Math.max(res, 1 + recur(idx + 1, netChange, requests));
        netChange[requests[idx][0]]++;
        netChange[requests[idx][1]]--;
        return res;
    }
}
