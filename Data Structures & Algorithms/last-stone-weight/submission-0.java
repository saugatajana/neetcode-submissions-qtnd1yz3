class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) {
            heap.offer(stone);
        }
        while(heap.size() >= 2) {
            int s1 = heap.poll();
            int s2 = heap.poll();
            if(s1!=s2) heap.offer(s1-s2);
        }
        return heap.isEmpty()?0:heap.peek();
    }
}
