class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long sum = mass;

        for (int x : asteroids) {
            if (x > sum) {
                return false;
            }
            sum += x;
        }

        return true;
    }
}
