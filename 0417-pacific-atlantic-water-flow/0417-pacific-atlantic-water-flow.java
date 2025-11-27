class Solution {

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public List<List<Integer>> pacificAtlantic(int[][] heights) {



        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];


        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();

        for(int i = 0; i < rows; i++){
            pacific.add(new int[]{i, 0});
            atlantic.add(new int[]{i, cols - 1});
        }

        for(int i = 0; i<cols; i++){
            pacific.add(new int[]{0, i});
            atlantic.add(new int[]{rows-1, i});
        }

        bfs(atlantic, atl, heights);
        bfs(pacific, pac, heights);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(atl[i][j] && pac[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void bfs(Queue<int[]> queue, boolean[][] boolArr, int[][] grid){

        while(!queue.isEmpty()){

            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            boolArr[row][col] = true;

            for(int[] dir : directions){
                int cr = row + dir[0];
                int cc = col + dir[1];

                if(cr >= 0 && cr < grid.length && cc >= 0 && cc < grid[0].length && grid[cr][cc] >= grid[row][col] && boolArr[cr][cc] == false){
                    queue.add(new int[]{cr, cc});
                }
            }
        }
    }
}