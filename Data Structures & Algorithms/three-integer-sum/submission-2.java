class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++) {
            if(i!=0 && nums[i] == nums[i-1]) continue;
            int requiredSum = -nums[i];
            int left = i+1, right = nums.length-1;

            while(left < right) {
                if(nums[left] + nums[right] == requiredSum) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    res.add(triplet);
                    left++;
                    right--;
                    //handle duplicates
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
                } else if(nums[left] + nums[right] > requiredSum) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
