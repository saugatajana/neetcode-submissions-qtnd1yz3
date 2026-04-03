class KthLargest {

    PriorityQueue<Integer> heap;
    int k;
    int[] nums;

    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;
        this.nums = nums;
        for(int i=0;i<nums.length;i++) {
            heap.offer(nums[i]);
            if(heap.size() > k) {
                heap.poll();
            }
                
        }
    }
    
    public int add(int val) {
        heap.offer(val); 
        if(heap.size() > k) {
            heap.poll();
        }
        
        return heap.peek();
    }
}
