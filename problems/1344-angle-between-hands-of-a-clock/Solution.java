class Solution {
    public double angleClock(int hour, int minutes) {
        hour %= 12;

        double m = 6 * minutes;
        double h = 30 * hour + 0.5 * minutes;

        double a = Math.max(m, h) - Math.min(m, h);

        return Math.min(a, 360.0 - a);
    }
}
