class Solution {

    public int islandPerimeter(int[][] grid) {

        int[][] positions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    break;
                }
            }
        }

        int per = 0;
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] pos : positions){

                int cr = r + pos[0];
                int cc = c + pos[1];

                if(cr < 0 || cc < 0 || cr >= grid.length || cc >= grid[0].length){
                    per++;
                }else if(grid[cr][cc]==0){
                    per++;
                }else if(!visited[cr][cc]){
                    visited[cr][cc] = true;
                    queue.add(new int[]{cr, cc});
                }
            }
        }
        return per;
    }
}