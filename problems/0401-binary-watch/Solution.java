class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int j = turnedOn - i;

            if (j < 0 || j > 6) {
                continue;
            }

            List<Integer> hours = new ArrayList<>();
            List<Integer> minutes = new ArrayList<>();

            dfs(3, i, 0, hours);
            dfs(5, j, 0, minutes);

            for (int h : hours) {
                if (h > 11) {
                    continue;
                }
                for (int m : minutes) {
                    if (m > 59) {
                        continue;
                    }
                    result.add(h + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }

        return result;
    }

    void dfs(int b, int c, int sum, List<Integer> result) {
        if (c == 0) {
            result.add(sum);
            return;
        }

        if (b < 0) {
            return;
        }

        dfs(b - 1, c - 1, sum + (1 << b), result);
        dfs(b - 1, c, sum, result);
    }
}
