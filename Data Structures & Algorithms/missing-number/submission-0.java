class Solution {
    public int missingNumber(int[] nums) {
        int total = 0;
        for(int num : nums) {
            total += num;
        }
        int n = nums.length;
        int expected = n * (n+1)/2;
        return expected-total;
    }
}
