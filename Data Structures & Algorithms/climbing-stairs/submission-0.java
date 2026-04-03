class Solution {
    public int climbStairs(int n) {
        int prev1 = 0, prev2 = 1, ways = 0;
        for(int i=0;i<=n;i++) {
            ways = prev1 + prev2;
            prev2 = prev1;
            prev1 = ways;
        }
        return ways;
    }
}
