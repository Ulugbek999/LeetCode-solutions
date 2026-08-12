class Solution {
    public int[] productExceptSelf(int[] nums) {


        //prefix sum

        int[] result = new int[nums.length];
        //prefix[0] = 1;
        int prefix = 1;

        //left -> right
        for(int i = 0; i<nums.length; i++){
            result[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;


        //right -> left
        for(int i = nums.length-1; i>=0; i--){
            result[i] *= suffix;
            suffix *= nums[i];
        }





        return result;

        
    }
}