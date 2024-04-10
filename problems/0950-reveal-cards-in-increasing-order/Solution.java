class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;

        Arrays.sort(deck);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(deck[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            queue.offer(queue.poll());
            queue.offer(deck[i]);
        }

        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }
        return res;
    }
}
