class Solution {

    List<List<Integer>> result;
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        this.nums = nums;
        backtrack(0, new ArrayList<>());
        return result;
    }

    private void backtrack(int index, List<Integer> curr) {
        if(index == nums.length) {
            List<Integer> list = new ArrayList<>(curr);
            result.add(list);
            return;
        }
        curr.add(nums[index]);
        backtrack(index+1, curr);
        curr.remove(curr.size()-1);
        backtrack(index+1, curr);
    } 
}
