class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;

        if (n % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);

        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : hand) {
            if (map.get(num) == 0) {
                continue;
            }
            
            for (int j = 0; j < groupSize; j++) {
                if (!map.containsKey(num + j) || map.get(num + j) == 0) {
                    return false;
                }
                map.put(num + j, map.get(num + j) - 1);
            }
        }

        return true;
    }
}
