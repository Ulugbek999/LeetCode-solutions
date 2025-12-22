class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int minH = grid[0][0], maxH = grid[0][0];
        for(int row = 0; row < n; row++){
            for(int col = 0; col<n; col++){
                maxH = Math.max(maxH, grid[row][col]);
                minH = Math.min(minH, grid[row][col]);
            }
        }

        int l = minH, r = maxH;
        while(l < r){
            int m = l + (r-l)/2;
            if(dfs(grid, visited, 0, 0, m)){
                r = m;
            }else{
                l = m + 1;
            }
            for(int row = 0; row < n; row++){
                Arrays.fill(visited[row], false);
            }
        }

        return r;



    }


    private boolean dfs(int[][] grid, boolean[][] visited, int r, int c, int t){
        if(r < 0 || c < 0 || r>=grid.length || c >= grid.length || visited[r][c] || grid[r][c] > t){
            return false;
        }

        if(r == grid.length - 1 && c == grid.length - 1){
            return true;//valid path
        }
        visited[r][c] = true;
        return dfs(grid, visited, r + 1, c, t) || dfs(grid, visited, r-1, c, t) || dfs(grid, visited, r, c+1, t) || dfs(grid, visited, r, c-1, t);
    }


}