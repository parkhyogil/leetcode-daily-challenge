class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();

        Map<Character, Integer> vowelBitMap = new HashMap<>();
        vowelBitMap.put('a', 1 << 0);
        vowelBitMap.put('e', 1 << 1);
        vowelBitMap.put('i', 1 << 2);
        vowelBitMap.put('o', 1 << 3);
        vowelBitMap.put('u', 1 << 4);
        
        Map<Integer, Integer> bitmaskIndexMap = new HashMap<>();
        bitmaskIndexMap.put(0, -1);

        int bitmask = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (vowelBitMap.containsKey(c)) {
                bitmask ^= vowelBitMap.get(c);
            }

            if (bitmaskIndexMap.containsKey(bitmask)) {
                maxLength = Math.max(maxLength, i - bitmaskIndexMap.get(bitmask));
            } else {
                bitmaskIndexMap.put(bitmask, i);
            }
        }

        return maxLength;
    }
}
