class Solution {
    public int rob(int[] nums) {
        // int[] dp = new int[nums.length+1];
        // dp[0] = 0;
        // dp[1] = nums[0];
        // for(int i=1;i<nums.length;i++) {
        //     dp[i+1] = Math.max(dp[i], nums[i] + dp[i-1]);
        // }
        // return dp[nums.length];

        int prev2 = 0, prev1 = 0, money = 0;
        for(int i=0;i<nums.length;i++) {
            money = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = money;
        }
        return money;
    }
}
