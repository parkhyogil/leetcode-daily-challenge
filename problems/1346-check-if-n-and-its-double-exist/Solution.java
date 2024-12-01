class Solution {
    public boolean checkIfExist(int[] arr) {
        boolean[] exist = new boolean[4001];

        for (int val : arr) {
            if (exist[val * 2 + 2000] || (val % 2 == 0 && exist[val / 2 + 2000])) {
                return true;
            }
            exist[val + 2000] = true;
        }

        return false;
    }
}
