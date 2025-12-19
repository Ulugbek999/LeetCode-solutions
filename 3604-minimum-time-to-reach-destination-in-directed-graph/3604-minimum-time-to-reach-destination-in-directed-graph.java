class Solution {
    public int minTime(int n, int[][] edges) {
        
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        List<int[]>[] graph = new ArrayList[n];

        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] subArr : edges){
            int v = subArr[1];
            int timeStart = subArr[2];
            int timeEnd = subArr[3];
            graph[subArr[0]].add(new int[]{v, timeStart, timeEnd});
        }

        Comparator<int[]> sorter = Comparator.comparing((int[] arr) -> arr[1]);
        Queue<int[]> pq = new PriorityQueue<>(sorter);

        pq.offer(new int[]{0, 0});

        while(pq.isEmpty() == false){
            int[] curr = pq.poll();
            int u = curr[0];
            int timeStart = curr[1];
            if(timeStart > dist[u]) continue;

            for(int[] edge : graph[u]){

                int v = edge[0];
                int start = edge[1];
                int end = edge[2];

                if(timeStart > end){
                    continue;
                }

                int newTime;
                if(timeStart < start){
                    newTime = start + 1;
                }else{
                    newTime = timeStart + 1;
                }

                if(newTime < dist[v]){
                    dist[v] = newTime;
                    pq.offer(new int[]{v, newTime});
                }
            }
        }

        return dist[n-1] == Integer.MAX_VALUE ? -1 : dist[n-1];
    }
}