class Solution {


    public int minimumEffortPath(int[][] heights) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing((int[] arr) -> arr[2]));
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        


        queue.offer(new int[]{0, 0, 0});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int effort = curr[2];

            if(visited[x][y] == true){
                continue;
            }else{
                visited[x][y] = true;
            }

            if(x == heights.length-1 && y == heights[0].length-1) return effort;

            for(int[] dir : directions){
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX >= 0 && newY >= 0 && newX < heights.length && newY < heights[0].length){

                    int newEffort = Math.max(effort, Math.abs(heights[x][y] - heights[newX][newY]));
                    queue.offer(new int[]{newX, newY, newEffort});
                }
            }

        }

        return - 1;
    }
}