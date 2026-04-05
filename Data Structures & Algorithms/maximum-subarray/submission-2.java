class Solution {
    public int maxSubArray(int[] nums) {
        int maxSubarray = Integer.MIN_VALUE;
        int currTotal = 0;
        for(int i=0;i<nums.length;i++) {
            currTotal += nums[i];
            if(nums[i] > currTotal) {
                currTotal = nums[i];
            }
            maxSubarray = Math.max(currTotal, maxSubarray);
        }
        return maxSubarray;
    }
}
