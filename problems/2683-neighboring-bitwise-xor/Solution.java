class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int currBit = 0;
        
        for (int val : derived) {
            if (val == 1) {
                currBit ^= 1;
            }
        }

        return currBit == 0;
    }
}
