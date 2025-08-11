import java.util.*;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // Pair nums2 with nums1
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i]; // nums2 value
            pairs[i][1] = nums1[i]; // nums1 value
        }

        // Sort by nums2 in descending order
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0, maxScore = 0;

        for (int[] pair : pairs) {
            int val1 = pair[1]; // nums1 value
            int val2 = pair[0]; // nums2 value

            minHeap.offer(val1);
            sum += val1;

            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                maxScore = Math.max(maxScore, sum * val2);
            }
        }

        return maxScore;
    }
}
