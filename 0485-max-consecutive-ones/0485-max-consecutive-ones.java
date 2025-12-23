class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int l = 0;
        int max = 0;
        int counter = 0;

        for(int r = 0; r<nums.length; r++){

            if(nums[r] == 1){
                counter++;
            }
            if(nums[r] == 0 || r == nums.length - 1 ){
                max = Math.max(max, counter);
                counter = 0;
            }
            

        }


        return max;
        
    }
}