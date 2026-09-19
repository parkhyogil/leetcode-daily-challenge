class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x = xCenter;
        int y = yCenter;

        if (x >= x1 && x <= x2 && y >= y1 && y <= y2) {
            return true;
        }

        if (getD(x, y, x1, y1) <= radius || getD(x, y, x2, y2) <= radius || getD(x, y, x1, y2) <= radius || getD(x, y, x2, y1) <= radius) {
            return true;
        }

        if (y >= y1 && y <= y2 && (getD(x, y, x1, y) <= radius || getD(x, y, x2, y) <= radius)) {
            return true;
        }

        if (x >= x1 && x <= x2 && (getD(x, y, x, y1) <= radius || getD(x, y, x, y2) <= radius)) {
            return true;
        }

        return false;
    }

    double getD(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
