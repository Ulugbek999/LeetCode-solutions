class Solution {
    public int minTime(int n, int[][] edges) {

        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        List<int[]>[] graph = new ArrayList[n];
        
        for(int i = 0; i<n; i++){
            graph[i] = new ArrayList<>();
        }        
        for(int[] edge : edges){
            graph[edge[0]].add(new int[]{edge[1], edge[2], edge[3]});
        }

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing((int[] arr) -> arr[1]));
        queue.offer(new int[]{0, 0});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int u = curr[0];
            int time = curr[1];
            if(time > distances[u]) continue;
    
            for(int[] edge: graph[u]){

                int v = edge[0];
                int start = edge[1];
                int end = edge[2];

                if(time > end){
                    continue;
                }

                int newTime;

                if(time < start){
                    newTime = start + 1;
                }else{
                    newTime = time + 1;
                }

                if(newTime < distances[v]){
                    distances[v] = newTime;
                    queue.offer(new int[]{v, newTime});
                }
            }
        }


        return distances[distances.length-1] != Integer.MAX_VALUE ? distances[distances.length-1] : -1;



    }
}