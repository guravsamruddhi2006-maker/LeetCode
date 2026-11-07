import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> free = new PriorityQueue<>(
            (a, b) -> a[0] != b[0]
                ? Integer.compare(a[0], b[0])
                : Integer.compare(a[1], b[1])
        );

        // Busy servers: [available time, weight, index]
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] != b[0]
                ? Long.compare(a[0], b[0])
                : (a[1] != b[1]
                    ? Long.compare(a[1], b[1])
                    : Long.compare(a[2], b[2]))
        );

        for (int i = 0; i < servers.length; i++) {
            free.offer(new int[]{servers[i], i});
        }

        int[] ans = new int[tasks.length];
        long time = 0;

        for (int j = 0; j < tasks.length; j++) {
            time = Math.max(time, j);

            if (free.isEmpty()) {
                time = Math.max(time, busy.peek()[0]);
            }

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                long[] server = busy.poll();
                free.offer(new int[]{(int) server[1], (int) server[2]});
            }

            int[] server = free.poll();
            int weight = server[0];
            int index = server[1];

            ans[j] = index;
            busy.offer(new long[]{time + tasks[j], weight, index});
        }

        return ans;
    }
}