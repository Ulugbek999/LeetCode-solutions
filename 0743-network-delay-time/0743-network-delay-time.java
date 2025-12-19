class Solution {


    public int networkDelayTime(int[][] times, int n, int k) {

        

        List<int[]>[] graph = new ArrayList[n + 1];
        //      int[] = new int[n + 1]
        // {
        //     [{vertex, weight}],
        //     [{vertex, weight}],
        //     [{vertex, weight}, {vertex, weight}, {vertex, weight}],
        //     [],
        //     [{vertex, weight}, {vertex, weight}]
        // }
        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        //building the adjacency graph
        for(int[] time : times){
            graph[time[0]].add(new int[]{time[1], time[2]});
        }

        //now initialize the distance graph:
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; //mark the kth vertex as the start, by changing its distance to 0;

        Comparator<int[]> sorter = Comparator.comparing((int[] arr) -> arr[1]); 
        Queue<int[]> pq = new PriorityQueue<>(sorter); //setting up a min heap to poll() the closest vertex;

        pq.offer(new int[]{k, 0});

        while(pq.isEmpty() == false){
            int[] closest = pq.poll();
            int u = closest[0];//vertex
            int d = closest[1]; //distance to that vertex
            if(d > dist[u]) continue; //to skip the visited ones


            for(int[] edge : graph[u]){
               //graph[u] = [{v1, w1}, {v2, w2}, {v3, w3}] -> graph[u] could be this, 
               //so we are checking every place we could go from u.
               int v = edge[0]; //the current neighbor
               int w = edge[1]; //the edge weight or distance to go there
               int newDistance = d + w; //U's current weight is 'd', so d + the weight to the potential new vert -> 'w';
               if(newDistance < dist[v]){
                //relaxation:
                    dist[v] = newDistance;
                    pq.offer(new int[]{v, newDistance});
               }
            }

        }

        int maxTime = 0;

        for(int i = 1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;

            maxTime = Math.max(dist[i], maxTime);
        }


        return maxTime;
        
        //int[][] test = {{0, 1, 3}, {1, 2, 5}, {1, 3, 6}};


        // ArrayList<int[]> list = new ArrayList<>();
        // for(int[] time : test){
        //     list.add(time);
        // }

        // Comparator<int[]> sortByWeights = Comparator.comparing((int[] arr) -> arr[2]);
        // //list.sort(sortByWeights);

        // Queue<int[]> pq = new PriorityQueue<>(sortByWeights);
        // for(int[] time : tiems){
        //     if(time[0] == k){
        //         pq.offer(time);
        //         break;
        //     }
        // }


        // while(pq.isEmpty() == false){

        //     int[] subArr = pq.poll();


        // }


        // // for(int[] time : list){
        // //                System.out.print('(');
        // //     for(int i = 0; i<3; i++){
        // //         System.out.print(time[i]);
        // //         if(i == 0){
        // //             System.out.print("->");
        // //         }else if(i == 1){
        // //             System.out.print("; w = ");
        // //         }
        // //     }
        // //     System.out.print(")");
        // //     System.out.println(); 
        // // }



        // // for(int[] time : times){
        // //     System.out.print('(');
        // //     for(int i = 0; i<3; i++){
        // //         System.out.print(time[i]);
        // //         if(i == 0){
        // //             System.out.print("->");
        // //         }else if(i == 1){
        // //             System.out.print("; w = ");
        // //         }

        // //     }
        // //     System.out.print(")");
        // //     System.out.println();
        // // }

        // return 0;
        
    
    }

    


}