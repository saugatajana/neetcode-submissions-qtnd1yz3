class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for(int num : set) {
            int count = 0;
            if(!set.contains(num-1)) {
                while(set.contains(num)) {
                    count++;
                    num++;
                }
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}
