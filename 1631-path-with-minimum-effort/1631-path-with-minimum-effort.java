class Solution {

    //int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        minHeap.add(new int[]{0, 0, 0});
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(minHeap.isEmpty() == false){
            int[] current = minHeap.poll();
            int effort = current[0];
            int x = current[1];
            int y = current[2];

            if(x == heights.length - 1 && y == heights[0].length-1) return effort;

            if(visited[x][y] == true){
                continue;
            }
            //mark it as true if not visited.
            visited[x][y] = true;
            for(int[] dir : directions){
                int newX = dir[0] + x;
                int newY = dir[1] + y;

                if(newX < heights.length && newY < heights[0].length && newX >= 0 && newY >= 0 ){
                    int NewEffort = Math.max(effort, Math.abs(heights[newX][newY]-heights[x][y]));
                    minHeap.offer(new int[]{NewEffort, newX, newY});
                }   
            }
        }

        return - 1;
    }
}