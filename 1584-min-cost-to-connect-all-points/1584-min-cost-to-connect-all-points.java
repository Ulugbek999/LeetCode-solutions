class Solution {
    public int minCostConnectPoints(int[][] points) {

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing((int[] arr) -> arr[1]));
        boolean[] visited = new boolean[points.length];

        queue.add(new int[]{0, 0});
        int result = 0;
        int connected = 0;

        while(connected < points.length){
            int[] curr = queue.poll();
            int u = curr[0];
            int cost = curr[1];

            if(visited[u]) continue;
            int x = points[u][0];
            int y = points[u][1];
            
            result += cost;
            visited[u]= true;
            connected++;

            for(int v = 0; v<points.length; v++){

                int newX = points[v][0];
                int newY = points[v][1];

                int newDist = Math.abs(x - newX) + Math.abs(y - newY);
                queue.offer(new int[]{v, newDist});
            }
        }
        return result;
    }
}