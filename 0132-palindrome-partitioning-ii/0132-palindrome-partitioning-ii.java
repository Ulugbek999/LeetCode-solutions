class Solution {
    public int minCut(String s) {
        
        int n = s.length();
        int[] dp = new int[n];
        boolean[][] isPal = new boolean[n][n];


        //Phase 1: Computer all of the palindromic substrings
        for(int i = n-1; i>= 0; i--){
            for(int j = i; j<n;j++){
                if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || isPal[i+1][j-1] == true)){
                    isPal[i][j] = true;
                }
            }
        }
        //the palindromic substrings are calculate, now calculate minimum cuts.

        //Phase 2: Calculate the minimum number of cuts;
        for(int i = 0; i<n; i++){
            //initialize the worst case where we have cut before each character:
            dp[i] = i;
            for(int j = 0; j<=i;j++){
                if(isPal[j][i]){
                    dp[i] = (j==0) ? 0 : Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }
        return dp[n-1];
    }
}