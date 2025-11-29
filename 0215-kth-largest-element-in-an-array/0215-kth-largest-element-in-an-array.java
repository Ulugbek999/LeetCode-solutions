class Solution {
    public int findKthLargest(int[] nums, int k) {
        

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : nums){
            queue.offer(num);
        }

        int iterations = queue.size() - k;
        int result = 0;
        for(int i = 0; i<iterations+1; i++){
            result = queue.poll();
        }
        return result;




    }
}