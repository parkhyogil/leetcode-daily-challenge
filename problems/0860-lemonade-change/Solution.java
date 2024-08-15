class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollars = 0;
        int tenDollars = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fiveDollars++;
            } else if (bill == 10) {
                fiveDollars--;
                tenDollars++;
            } else {
                if (tenDollars > 0) {
                    tenDollars--;
                    fiveDollars--;
                } else {
                    fiveDollars -= 3;
                }
            }

            if (fiveDollars < 0 || tenDollars < 0) {
                return false;
            }
        }        

        return true;
    }
}
