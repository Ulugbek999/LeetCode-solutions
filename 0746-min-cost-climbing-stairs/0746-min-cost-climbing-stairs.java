

class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        int[] dp = new int[n+1];

        //Becasue it would take 0 currency to jump from before the staircase on either first or second step.
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i<=n; i++){
            dp[i] = Math.min(
                cost[i-1] + dp[i-1],
                cost[i-2] + dp[i-2]
            );
        }

        return dp[n];

    }
}