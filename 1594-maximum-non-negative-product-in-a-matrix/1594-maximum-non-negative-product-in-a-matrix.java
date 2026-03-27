class Solution {
    public int maxProductPath(int[][] grid) {

        long[][] min = new long[grid.length][grid[0].length];
        long[][] max = new long[grid.length][grid[0].length];
        min[0][0] = grid[0][0];
        max[0][0] = grid[0][0];
        long MOD = 1_000_000_007;

        //first row:
        for(int j = 1; j<grid[0].length; j++){
            max[0][j] = grid[0][j] * max[0][j-1];
            min[0][j] = max[0][j];
        }

               // first column
        for (int i = 1; i < grid.length; i++) {
            max[i][0] = max[i - 1][0] * grid[i][0];
            min[i][0] = max[i][0]; // same value
        }


        for(int i = 1; i<grid.length;i++){
            for(int j = 1; j<grid[0].length;j++){
                long currentVal = grid[i][j];


                long a = currentVal * max[i-1][j];
                long b = currentVal * min[i-1][j];
                long c = currentVal * max[i][j-1];
                long d = currentVal * min[i][j-1];

                max[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                min[i][j] = Math.min(Math.min(a, b), Math.min(c, d));


            }
        }


        long result = max[grid.length-1][grid[0].length-1];

        if(result < 0) return -1;

        return (int)(result % MOD);


    }
}