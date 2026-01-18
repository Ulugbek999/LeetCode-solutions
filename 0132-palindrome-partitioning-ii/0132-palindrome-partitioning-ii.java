class Solution {

    public int minCut(String s) {

        int n = s.length();
        int result = 0;
        boolean[][] isPal = new boolean[n][n];

        //precomputing palindrome numbers:
        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n; j++){

                if(s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPal[i + 1][j-1])){
                    isPal[i][j] = true;
                    // System.out.println("i = " + i + " j = " + j );
                }
            }
        }


        //Step 2: dp for minimum cuts
        int[] dp = new int[n];
        for(int i = 0; i<n; i++){
            dp[i] = i;//worst case

            for(int j = 0; j<=i; j++){
                if(isPal[j][i]){
                    dp[i] = (j==0) ? 0 : Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }

        

        
        return dp[n-1];

    }

}