class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;

        Set<Integer>[] sets = new HashSet[m];

        for (int i = 0; i < m; i++) {
            sets[i] = new HashSet<>();

            for (int j : languages[i]) {
                sets[i].add(j - 1);
            }
        }

        Set<Integer> unables = new HashSet<>();

        for (int[] e : friendships) {
            int a = e[0] - 1;
            int b = e[1] - 1;

            if (isUnable(a, b, sets)) {
                unables.add(a);
                unables.add(b);
            }
        }

        int[] count = new int[n + 1];
        int max = 0;

        for (int user : unables) {
            for (int lang : languages[user]) {
                count[lang]++;
                max = Math.max(max, count[lang]);            
            }
        }

        return unables.size() - max;
    }

    boolean isUnable(int a, int b, Set<Integer>[] sets) {
        for (int l : sets[a]) {
            if (sets[b].contains(l)) {
                return false;
            }
        }
        return true;
    }
}
