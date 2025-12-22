class Solution {


    public int networkDelayTime(int[][] times, int n, int k) {


        int[] dist = new int[n+1];
        // Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 1; i<=n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;

        List<int[]>[] graph = new ArrayList[n+1];
        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] time : times){
            graph[time[0]].add(new int[]{time[1], time[2]});
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] arr) -> arr[1]));
        pq.offer(new int[]{k, 0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];


            
            for(int[] edge : graph[u]){
                int v = edge[0];
                int t = edge[1];
                int newDist = d + t;

                if(newDist < dist[v]){
                    dist[v] = newDist;
                    pq.offer(new int[]{v, newDist});
                }

            }
        }

        int maxVal = 0;
        

        for(int d : dist){
            // System.out.println(d);
            if(d == Integer.MAX_VALUE) return -1;

            maxVal = Math.max(maxVal, d);
        }



        return maxVal;


    }
}