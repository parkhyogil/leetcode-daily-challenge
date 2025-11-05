class Solution {
    Map<Integer, Integer> leftFreq = new HashMap<>();
    Map<Integer, Integer> rightFreq = new HashMap<>();
    Queue<int[]> leftQueue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
    Queue<int[]> rightQueue = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;

        long[] result = new long[n - k + 1];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int v = nums[i];

            if (leftFreq.size() < x || leftFreq.containsKey(v)) {
                sum += v;

                leftFreq.merge(v, 1, Integer::sum);
                leftQueue.offer(new int[] {v, leftFreq.get(v)});
            } else {
                rightFreq.merge(v, 1, Integer::sum);
                rightQueue.offer(new int[] {v, rightFreq.get(v)});

                sum = update(sum);
            }

            if (i - k + 1 >= 0) {
                result[i - k + 1] = sum;

                v = nums[i - k + 1];
                if (leftFreq.containsKey(v)) {
                    sum -= v;

                    leftFreq.merge(v, -1, Integer::sum);
                    leftQueue.offer(new int[] {v, leftFreq.get(v)});

                    sum = update(sum);
                } else {
                    rightFreq.merge(v, -1, Integer::sum);
                    rightQueue.offer(new int[] {v, rightFreq.get(v)});
                }
            }
        }

        return result;
    }

    private long update(long sum) {
        while (!isValid(leftQueue, leftFreq)) {
            leftQueue.poll();
        }
        while (!isValid(rightQueue, rightFreq)) {
            rightQueue.poll();
        }

        int[] a = leftQueue.poll();
        int[] b = rightQueue.poll();

        if (a == null && b == null) {
            return sum;
        }

        if (a == null) {
            rightFreq.remove(b[0]);
            if (b[1] > 0) {
                leftFreq.put(b[0], b[1]);
                leftQueue.offer(b);
                sum += (long) b[0] * b[1];
            }
        } else if (b == null) {
            if (a[1] == 0) {
                leftFreq.remove(a[0]);
            } else {
                leftQueue.offer(a);
            }
        } else {
            if (a[1] > b[1] || (a[1] == b[1] && a[0] > b[0])) {
                if (a[1] > 0) {
                    leftQueue.offer(a);
                } else {
                    leftFreq.remove(a[0]);
                }
                if (b[1] > 0) {
                    rightQueue.offer(b);
                } else {
                    rightFreq.remove(b[0]);
                }
            } else {
                sum += (long) b[0] * b[1] - (long) a[0] * a[1];
                leftFreq.remove(a[0]);
                rightFreq.remove(b[0]);
                if (a[1] > 0) {
                    rightFreq.put(a[0], a[1]);
                    rightQueue.offer(a);
                }
                if (b[1] > 0) {
                    leftFreq.put(b[0], b[1]);
                    leftQueue.offer(b);
                }
            }
        }

        return sum;
    }

    private boolean isValid(Queue<int[]> queue, Map<Integer, Integer> freq) {
        return queue.isEmpty() || (freq.containsKey(queue.peek()[0]) && queue.peek()[1] == freq.get(queue.peek()[0]));
    }
}
