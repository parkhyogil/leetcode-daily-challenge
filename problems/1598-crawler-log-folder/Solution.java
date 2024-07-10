class Solution {
    public int minOperations(String[] logs) {
        int res = 0;

        for (String log : logs) {
            if (log.equals("../")) {
                res = Math.max(res - 1, 0);
            } else if (!log.equals("./")) {
                res++;
            }
        }

        return res;
    }
}
