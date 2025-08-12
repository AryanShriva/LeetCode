import java.util.*;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long totalCost = 0;

        // Min Heaps: store {cost, index}
        PriorityQueue<int[]> leftHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> rightHeap = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int i = 0, j = n - 1;

        // Fill initial left candidates
        for (; i < candidates && i <= j; i++) {
            leftHeap.offer(new int[]{costs[i], i});
        }

        // Fill initial right candidates
        for (int count = 0; count < candidates && j >= i; count++, j--) {
            rightHeap.offer(new int[]{costs[j], j});
        }

        // Hire k workers
        for (int hired = 0; hired < k; hired++) {
            if (rightHeap.isEmpty() || (!leftHeap.isEmpty() && leftHeap.peek()[0] <= rightHeap.peek()[0])) {
                int[] worker = leftHeap.poll();
                totalCost += worker[0];

                if (i <= j) {
                    leftHeap.offer(new int[]{costs[i], i});
                    i++;
                }
            } else {
                int[] worker = rightHeap.poll();
                totalCost += worker[0];

                if (i <= j) {
                    rightHeap.offer(new int[]{costs[j], j});
                    j--;
                }
            }
        }
        return totalCost;
    }
}
