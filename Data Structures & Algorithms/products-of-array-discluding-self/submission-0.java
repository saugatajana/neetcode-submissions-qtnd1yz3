class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        //left product 
        int leftProduct = 1;
        for(int i=0;i<nums.length;i++) {
            product[i] = leftProduct;
            leftProduct *= nums[i];
        }

        //right product
        int rightProduct = 1;
        for(int i=nums.length-1;i>=0;i--) {
            product[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return product;
    }
}  
