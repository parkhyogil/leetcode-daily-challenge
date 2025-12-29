class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        List<Character>[][] topBlocks = new ArrayList[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                topBlocks[i][j] = new ArrayList<>();
            }
        }

        for (String s : allowed) {
            topBlocks[s.charAt(0) - 'A'][s.charAt(1) - 'A'].add(s.charAt(2));
        }

        return recur(bottom, topBlocks, new HashSet<>());
    }

    boolean recur(String line, List<Character>[][] topBlocks, HashSet<String> failed) {
        if (line.length() == 1) {
            return true;
        }

        if (failed.contains(line)) {
            return false;
        }

        List<List<Character>> list = new ArrayList<>();

        for (int i = 0; i < line.length() - 1; i++) {
            char l = line.charAt(i);
            char r = line.charAt(i + 1);

            list.add(topBlocks[l - 'A'][r - 'A']);
        }

        List<String> nextLines = new ArrayList<>();
        generate(0, new char[line.length() - 1], list, nextLines);

        for (String nextLine : nextLines) {
            if (recur(nextLine, topBlocks, failed)) {
                return true;
            }
        }

        failed.add(line);

        return false;
    }

    void generate(int i, char[] line, List<List<Character>> list, List<String> nextLines) {
        if (i == list.size()) {
            nextLines.add(String.valueOf(line));
            return;
        }

        for (char c : list.get(i)) {
            line[i] = c;
            generate(i + 1, line, list, nextLines);
        }
    }
}
