class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int[] result = new int[cost.length];
        result[0] = cost[0];
        result[1] = cost[1];

        for(int i = 2; i < cost.length; i++){

            result[i] = Math.min((result[i-2] + cost[i]), (result[i-1] + cost[i]));
           
        }
        int n = result.length-1;

        return Math.min(result[n], result[n-1]);
        
    }
}