class Solution {
    public int findKthLargest(int[] nums, int k) {
        

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing((Integer l) -> l).reversed());
        for(int num : nums){
            queue.offer(num);
        }

        int result = 0;
        for(int i = 0; i<k;i++){
            result = queue.poll();
        }

        return result;




    }
}