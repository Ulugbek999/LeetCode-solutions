class Solution {
    public int lastStoneWeight(int[] stones) {

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparing((Integer l) -> l).reversed());

        for(int stone : stones){
            queue.offer(stone);
        }
        int val = 0;
        while(queue.size() > 1){
            int heavierStone = queue.poll();
            int lighterStone = queue.poll();
            if(heavierStone == lighterStone){
                continue;
            }else{
                val = heavierStone - lighterStone;
                queue.offer(val);
            }
        }
        queue.offer(0);
        return queue.peek();
        
    }
}