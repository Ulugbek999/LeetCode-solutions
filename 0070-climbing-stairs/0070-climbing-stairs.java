class Solution {
    public int climbStairs(int n) {
        
        if(n == 1 || n == 1){
            return 1;
        }


        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;

        for(int i = 2; i <= n; i++){

            result[i] = result[i-2] + result[i-1]; 
            //System.out.println(result[i]);

        }
        
        return result[n-2] + result[n-1];

    }
     
}