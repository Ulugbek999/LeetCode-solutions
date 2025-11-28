class Solution {

    public int[] findRedundantConnection(int[][] edges) {

        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length+1];
        for(int i = 0; i <= edges.length; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            if(!union(parent, rank, a, b)){
                return new int[]{a, b};
            }


        }
        // int[] test = {1, 2, 2, 1};
        // int n = 3;
        // System.out.println(find(test, n));


        return new int[0];
    }
    //[1, 2, 2, 2]
    //[0, 1, 2, 3]



    //using union find or disjoint set union algorithm to detect cycles.
    //find function returns a parent: - a parent of a node should be equal to the value of the node itself
    private int find(int[] par, int n){
        
        // for(int i = 0; i<par.length; i++){
        //     System.out.print(par[i] + " " );
        // }
        // System.out.println();

        while(n != par[n]){
            n = par[par[n]];
        }

        return n;
    }

    //check if two numbers are in the same set, if so that means that there is probably a cycle:
    private boolean union(int[] par, int[] rank, int n1, int n2){
        
        int a = find(par, n1);
        int b = find(par, n2);

        if(a == b){
            return false;
        }
        if(rank[a] > rank[b]){
            par[b] = par[a];
            rank[a] += rank[b];
        }else{
            rank[b] += rank[a];
            par[a] = par[b];
        }

        // for(int i = 0; i<par.length; i++){
        //     System.out.print(rank[i] + " " );
        // }
        // System.out.println();
        
        return true;
    }


}