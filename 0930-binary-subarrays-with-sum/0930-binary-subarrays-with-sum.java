class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
    

        return helper(goal, nums) - helper(goal-1, nums);
    }

    private int helper(int k, int[] nums){

        int left = 0;
        int count = 0;

        if(k <  0) return 0;

        int runningSum = 0;

        for(int right = 0; right < nums.length; right++){

            runningSum += nums[right];

            while(runningSum > k){
                runningSum -= nums[left];
                left++;
            }

            if(runningSum <= k){
                count += (right - left + 1);
            }

        }

        return count;
    }


}