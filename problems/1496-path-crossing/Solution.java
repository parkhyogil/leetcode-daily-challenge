class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        Set<Integer> visit = new HashSet<>();
        visit.add(0);

        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else {
                x--;
            }

            if (visit.contains(x * 10000 + y)) {
                return true;
            }
            visit.add(x * 10000 + y);
        }
        return false;
    }
}
