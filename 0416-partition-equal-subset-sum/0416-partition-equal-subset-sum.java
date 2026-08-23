class Solution {



    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0) return false; //not even can't devide evenly.

        int target = sum / 2;

        boolean[] dp = new boolean[target  + 1]; //for each number, we check whether getting a sum that equals to that number is possible. (true/false);

        dp[0] = true;

        for(int num : nums){

            for(int j = target; j >= num; j--){

                dp[j] = dp[j] || dp[j-num];

            }
        }


        return dp[target];
        
    }
}