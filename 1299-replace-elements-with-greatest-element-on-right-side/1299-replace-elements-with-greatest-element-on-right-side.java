class Solution {
    public int[] replaceElements(int[] arr) {

        int[] dp = new int[arr.length];

        dp[dp.length-1] = -1;
        int runningMax = 0;
        int j = dp.length-2;
        for(int i = arr.length-1;i>0;i--){
            runningMax = Math.max(runningMax, arr[i]);
            dp[j--] = runningMax;
        }   

        return dp;

    }
}