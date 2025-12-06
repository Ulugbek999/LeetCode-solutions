class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean[] visited = new boolean[points.length];
        int minimumCost = 0;
        minHeap.offer(new int[]{0, 0});
        

        while(!minHeap.isEmpty()){
            int[] current = minHeap.poll();
            int vertex = current[0];
            int weight = current[1];

            if (visited[vertex]){
                continue;
            }
            
            visited[vertex] = true;
            minimumCost+=weight;
            
            for(int i=0; i<points.length; i++){
                if(!visited[i]){
                    int distance = Math.abs(points[i][0] - points[vertex][0]) + Math.abs(points[i][1] - points[vertex][1]);
                    minHeap.offer(new int[]{i, distance});
                    
                }
            }
        }   


        return minimumCost;




    }
}