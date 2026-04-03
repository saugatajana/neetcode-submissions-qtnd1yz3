class Solution {
    int[] nums;
    int target;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        res = new ArrayList<>();
        backtrack(0, new ArrayList<>(), 0);
        return res;
    }

    public void backtrack(int index, List<Integer> curr, int currSum) {
        if(currSum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(index >= nums.length || currSum > target) return;
        for(int i=index;i<nums.length;i++) {
            curr.add(nums[i]);
            backtrack(i, curr,currSum + nums[i]);
            curr.remove(curr.size()-1);
        }
    }
}
