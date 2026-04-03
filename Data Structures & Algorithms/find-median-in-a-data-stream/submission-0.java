class MedianFinder {
    PriorityQueue<Double> maxHeap;
    PriorityQueue<Double> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(Double.valueOf(num));
            if(maxHeap.size() - minHeap.size() > 1) {
                double val = maxHeap.poll();
                minHeap.offer(val);
            }
        } else {
            minHeap.offer(Double.valueOf(num));
            if(minHeap.size() - maxHeap.size() > 1) {
                double val = minHeap.poll();
                maxHeap.offer(val);
            }
        }
    }
    
    public double findMedian() {
        int totalSize = maxHeap.size() + minHeap.size();
        double res = 0;
        if(totalSize%2 != 0) {
            if(maxHeap.size() >= minHeap.size()) return maxHeap.peek();
            else return minHeap.peek();
        } else {
            res = (maxHeap.peek() + minHeap.peek())/2;
        }
        return res;
    }
}
