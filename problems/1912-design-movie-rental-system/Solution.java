import java.util.*;

class MovieRentingSystem {
    Map<Long, int[]> movieMap;
    Map<Integer, Queue<int[]>> unrentedQueueMap;
    Set<Long> isRented;
    Queue<int[]> rentedQueue;

    public MovieRentingSystem(int n, int[][] entries) {
        movieMap = new HashMap<>();
        unrentedQueueMap = new HashMap<>();
        isRented = new HashSet<>();
        rentedQueue = new PriorityQueue<>((a, b) -> a[2] != b[2] ? a[2] - b[2] : (a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]));

        for (int[] e : entries) {
            movieMap.put(getKey(e[0], e[1]), e);
            unrentedQueueMap.computeIfAbsent(e[1], k -> new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2])).offer(e);
        }
    }

    public List<Integer> search(int movie) {
        Queue<int[]> queue = unrentedQueueMap.get(movie);

        if (queue == null) {
            return new ArrayList<>();
        }

        List<int[]> cheapest = new ArrayList<>();

        Set<Long> added = new HashSet<>();

        while (!queue.isEmpty() && cheapest.size() < 5) {
            int[] e = queue.poll();
            long key = getKey(e[0], e[1]);

            if (isRented.contains(key) || added.contains(key)) {
                continue;
            }

            added.add(key);
            cheapest.add(e);
        }

        List<Integer> result = new ArrayList<>();

        for (int[] e : cheapest) {
            result.add(e[0]);
            queue.offer(e);
        }

        return result;
    }

    public void rent(int shop, int movie) {
        long key = getKey(shop, movie);
        isRented.add(key);
        rentedQueue.offer(movieMap.get(key));
    }

    public void drop(int shop, int movie) {
        long key = getKey(shop, movie);
        isRented.remove(key);
        unrentedQueueMap.get(movie).offer(movieMap.get(key));
    }

    public List<List<Integer>> report() {
        Queue<int[]> queue = rentedQueue;
        List<int[]> cheapest = new ArrayList<>();

        Set<Long> added = new HashSet<>();

        while (!queue.isEmpty() && cheapest.size() < 5) {
            int[] e = queue.poll();
            long key = getKey(e[0], e[1]);

            if (!isRented.contains(key) || added.contains(key)) {
                continue;
            }

            added.add(key);
            cheapest.add(e);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int[] e : cheapest) {
            result.add(List.of(e[0], e[1]));
            queue.offer(e);
        }

        return result;
    }

    private static long getKey(int shop, int movie) {
        return (long) shop * 100000 + movie;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */
