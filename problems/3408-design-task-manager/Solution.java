class TaskManager {
    Map<Integer, Integer> taskPriority, taskUser;
    PriorityQueue<int[]> queue;

    public TaskManager(List<List<Integer>> tasks) {
        taskPriority = new HashMap<>();
        taskUser = new HashMap<>();
        queue = new PriorityQueue<>((a, b) -> a[2] == b[2] ? b[1] - a[1] : b[2] - a[2]);

        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        taskPriority.put(taskId, priority);
        taskUser.put(taskId, userId);
        queue.offer(new int[] {userId, taskId, priority});
    }
    
    public void edit(int taskId, int newPriority) {
        taskPriority.put(taskId, newPriority);
        queue.offer(new int[] {taskUser.get(taskId), taskId, newPriority});
    }
    
    public void rmv(int taskId) {
        taskPriority.remove(taskId);
        taskUser.remove(taskId);
    }
    
    public int execTop() {
        while (!queue.isEmpty()) {
            int[] t = queue.poll();

            if (taskPriority.containsKey(t[1]) && t[2] == taskPriority.get(t[1]) && t[0] == taskUser.get(t[1])) {
                rmv(t[1]);
                return t[0];
            }
        }

        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
