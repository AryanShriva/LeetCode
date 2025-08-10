import java.util.*;

class SmallestInfiniteSet {
    private int current;
    private PriorityQueue<Integer> minHeap;
    private Set<Integer> inHeap;

    public SmallestInfiniteSet() {
        current = 1;
        minHeap = new PriorityQueue<>();
        inHeap = new HashSet<>();
    }
    
    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int smallest = minHeap.poll();
            inHeap.remove(smallest);
            return smallest;
        }
        return current++;
    }
    
    public void addBack(int num) {
        if (num < current && !inHeap.contains(num)) {
            minHeap.offer(num);
            inHeap.add(num);
        }
    }
}


/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */