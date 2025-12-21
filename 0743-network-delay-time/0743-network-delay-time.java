class Solution {


    public int networkDelayTime(int[][] times, int n, int k) {

        List<int[]>[] graph = new ArrayList[n+1];

        int[] dist = new int[n+1];
        for(int i = 1; i<=n; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        //               1             2 
        //graph = {[{2,2}, {3, 3}], [{1, 1}, {3, 1}]} -> this is what graph looks like

        for(int[] subArr : times){
            graph[subArr[0]].add(new int[]{subArr[1], subArr[2]});
        }

        dist[k] = 0;

        Comparator<int[]> customSort = Comparator.comparing((int[] arr) -> arr[1]);
        Queue<int[]> queue = new PriorityQueue<>(customSort);

        queue.offer(new int[]{k, 0});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int u = curr[0];
            int d = curr[1];

            for(int[] subArr : graph[u]){
                int v = subArr[0];
                int newDist = d + subArr[1];//the dist to that vertex;
                if(newDist < dist[v]){
                    dist[v] = newDist;
                    //and we travel there:
                    queue.offer(new int[]{v, newDist});
                }
            }
        }


        // for(int distance : dist){
        //     System.out.println(distance);
        // }
        int result = 0;
        for(int num : dist){
            if(num == Integer.MAX_VALUE) return -1;

            result = Math.max(result, num);
        }

        

        return result;

    }

    


}