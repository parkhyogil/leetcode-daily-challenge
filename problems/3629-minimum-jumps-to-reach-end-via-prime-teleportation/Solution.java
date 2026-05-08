class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;

        int max = 0;

        for (int x : nums) {
            max = Math.max(max, x);
        }

        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j <= max; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            for (int j = 0; j < primes.size() && primes.get(j) <= x && !isPrime[x]; j++) {
                int p = primes.get(j);
                if (x % p == 0) {
                    map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                    while (x % p == 0) {
                        x /= p;
                    }
                }
            }

            if (isPrime[x]) {
                map.computeIfAbsent(x, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int i = queue.poll();

                if (i == n - 1) {
                    return result;
                }

                if (isPrime[nums[i]] && map.containsKey(nums[i])) {
                    for (int j : map.get(nums[i])) {
                        if (!visited[j]) {
                            queue.offer(j);
                            visited[j] = true;
                        }
                    }
                    map.remove(nums[i]);
                }

                if (i - 1 >= 0 && !visited[i - 1]) {
                    queue.offer(i - 1);
                    visited[i - 1] = true;
                }
                if (i + 1 < n && !visited[i + 1]) {
                    queue.offer(i + 1);
                    visited[i + 1] = true;
                }
            }

            result++;
        }

        return n;
    }
}
