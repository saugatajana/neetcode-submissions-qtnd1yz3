class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);   
        }

        for(int key : map.keySet()) {
            int[] arr = new int[2];
            arr[0] = key;
            arr[1] = map.get(key);
            if(queue.isEmpty() || queue.size() < k) {
                queue.offer(arr);
            } else if(queue.peek()[1] < arr[1]) {
                queue.poll();
                queue.offer(arr);
            }
        }

        int[] res = new int[k];
        int index = 0;
        while(!queue.isEmpty()) {
            res[index] = queue.poll()[0];
            index++;
        }
        return res;
    }
}
