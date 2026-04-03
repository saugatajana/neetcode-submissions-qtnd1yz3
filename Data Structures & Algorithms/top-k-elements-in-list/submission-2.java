class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(num));
        }

        List<Integer>[] bucket = new List[maxFreq + 1];
        for(int key : map.keySet()) {
            int freq = map.get(key);
            if(bucket[freq] == null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = bucket.length-1; i >= 1 && index < k; i--) {
            if(bucket[i] != null) {
                List<Integer> list = bucket[i];
                for(int n : list) {
                    res[index] = n;
                    index++;
                    if(index == res.length) break;
                }
            }
        }
        return res;
    }
}
