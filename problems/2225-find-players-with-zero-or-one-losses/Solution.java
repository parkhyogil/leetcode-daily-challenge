class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] count = new int[100001];

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            if (count[winner] == 0) {
                count[winner] = -1;
            }

            if (count[loser] == -1) {
                count[loser] = 1;
            } else {
                count[loser]++;
            }
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 1; i < count.length; i++) {
            if (count[i] == -1) {
                list1.add(i);
            } else if (count[i] == 1) {
                list2.add(i);
            }
        }

        return List.of(list1, list2);
    }
}
