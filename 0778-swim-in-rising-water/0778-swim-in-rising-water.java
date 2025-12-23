class Solution {
    public int swimInWater(int[][] grid) {
    

        int minHeight = 0;
        int maxHeight = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                minHeight = Math.min(grid[i][j], minHeight);
                maxHeight = Math.max(grid[i][j], maxHeight);
            }
        }

        boolean[][] visited = new boolean[grid.length][grid.length];

        int l = minHeight;
        int r = maxHeight;

        while(l < r){

            int mid = l + (r-l)/2;
            
            if(dfs(grid, visited, 0, 0, mid)){
                r = mid;
            }else{
                l = mid + 1;
            }

            for(int i = 0; i<visited.length; i++){
                for(int j = 0; j<visited[0].length; j++){
                    visited[i][j] = false;
                }
            }

        }

        return l;
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int r, int c, int m){

        if(r >= grid.length || c >= grid.length || r < 0 || c < 0 || visited[r][c] == true || grid[r][c] > m){
            return false;
        }

        visited[r][c] = true;

        if(r == grid.length-1 && c == grid.length - 1){
            return true;
        }

        return dfs(grid, visited, r+1, c, m) || dfs(grid, visited, r-1, c, m) || dfs(grid, visited, r, c+1, m) || dfs(grid, visited, r, c-1, m);



    }


}