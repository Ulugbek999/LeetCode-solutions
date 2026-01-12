class Solution {
    public int minSubArrayLen(int target, int[] nums) {



        int left = 0;
        int max = Integer.MAX_VALUE;
        int runningSum = 0;

        for(int right = 0; right < nums.length; right++){
            runningSum += nums[right];
            while(runningSum >= target){
                    max = Math.min(max, right - left + 1);
                
                runningSum -= nums[left];
                left++;
            }

        }

        return max == Integer.MAX_VALUE ? 0 : max;



        
    }
}