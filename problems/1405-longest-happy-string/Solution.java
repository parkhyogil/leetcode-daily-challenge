class Solution {
    public String longestDiverseString(int a, int b, int c) {
        char[] chars = new char[] {'a', 'b', 'c'};
        int[] count = new int[] {a, b, c};

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j) -> Integer.compare(count[j], count[i]));
        for (int i = 0; i < 3; i++) {
            if (count[i] > 0) {
                maxHeap.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int first = maxHeap.poll();

            if (canPutOneLetter(chars[first], sb)) {
                sb.append(chars[first]);
                count[first]--;
            } else {
                if (maxHeap.isEmpty()) {
                    break;
                }

                int second = maxHeap.poll();

                sb.append(chars[second]);
                count[second]--;

                if (count[second] > 0) {
                    maxHeap.offer(second);
                }
            }

            if (count[first] > 0) {
                maxHeap.offer(first);
            }
        }

        return sb.toString();
    }

    private boolean canPutOneLetter(char c, StringBuilder sb) {
        int length = sb.length();

        return !(length >= 2 && sb.charAt(length - 1) == c && sb.charAt(length - 2) == c);
    }
}
