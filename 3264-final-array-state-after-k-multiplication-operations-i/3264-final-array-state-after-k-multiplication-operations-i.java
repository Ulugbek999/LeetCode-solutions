class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        
        Queue<int[]> queue = new PriorityQueue<>(
            (a, b) -> {
                if(a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }

        );


        for(int i = 0; i<nums.length; i++){
            queue.offer(new int[]{nums[i], i});
        }


        for(int i = 0; i<k;i++){
            int[] curr = queue.poll();
            curr[0] *= multiplier;
            nums[curr[1]] = curr[0];
            queue.offer(curr);
        }

        return nums;




    }
}