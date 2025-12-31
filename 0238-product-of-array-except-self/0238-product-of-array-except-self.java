class Solution {

    public int[] productExceptSelf(int[] nums) {
        int[] prefix1 = new int[nums.length];
        prefix1[0] = 1;
        for(int i = 1; i<nums.length; i++){
            prefix1[i] = prefix1[i-1] * nums[i-1]; 
        }        
    
        int[] result = new int[prefix1.length];
        int rightProduct = 1;
        for(int i = nums.length-2; i>=0; i--){
            //result[i] = result[i+1] * prefix1[i];
            rightProduct = nums[i+1] * rightProduct;
            prefix1[i] = rightProduct * prefix1[i];
        }

        return prefix1;
    
    
    }

}