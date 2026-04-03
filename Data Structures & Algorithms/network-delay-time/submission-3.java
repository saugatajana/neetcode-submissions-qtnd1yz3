class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int[] time : times) {
            List<int[]> list = adjList.getOrDefault(time[0], new ArrayList<>());
            list.add(new int[]{time[1], time[2]});
            adjList.put(time[0], list);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        heap.offer(new int[]{0, k});

        Map<Integer, Integer> delayMap = new HashMap<>();
        delayMap.put(k, 0);

        while(!heap.isEmpty()) {
            int[] curr = heap.poll();
            int currNode = curr[1];
            int currTime = curr[0];
            if(currTime > delayMap.getOrDefault(currNode, Integer.MAX_VALUE)) 
                continue;
            List<int[]> neighbors = adjList.getOrDefault(currNode, new ArrayList<>());
            for(int[] neighbor : neighbors) {
                int timeTaken = neighbor[1] + currTime;
                if(!delayMap.containsKey(neighbor[0]) || timeTaken < delayMap.get(neighbor[0])) {
                    delayMap.put(neighbor[0], timeTaken);
                    heap.offer(new int[]{timeTaken, neighbor[0]});
                }
            }
        }
        if(delayMap.size() != n) return -1;
        return delayMap.values().stream().max(Integer::compare).get();
    }
}
