class Robot {
    int w, h, l, x, y, d;
    int[][] dir;
    String[] dirName;

    public Robot(int width, int height) {
        w = width - 1;
        h = height - 1;
        l = w * 2 + h * 2;
        x = 0;
        y = 0;
        d = 0;
        dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        dirName = new String[] {"East", "North", "West", "South"};
    }
    
    public void step(int num) {
        num = num % l + l;

        while (num > 0) {
            int nx = x + dir[d][0] * num;
            int ny = y + dir[d][1] * num;

            if (nx < 0 || nx > w || ny < 0 || ny > h) {
                d = (d + 1) % 4;
                if (nx < 0) {
                    num = -nx;
                    nx = 0;
                } else if (nx > w) {
                    num = nx - w;
                    nx = w;
                } else if (ny < 0) {
                    num = -ny;
                    ny = 0;
                } else {
                    num = ny - h;
                    ny = h;
                }
            } else {
                num = 0;
            }

            x = nx;
            y = ny;
        }
    }
    
    public int[] getPos() {
        return new int[] {x, y};
    }
    
    public String getDir() {
        return dirName[d];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
