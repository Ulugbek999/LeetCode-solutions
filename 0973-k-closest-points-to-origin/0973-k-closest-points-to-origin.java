class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparing( (int[] nums) -> distance(nums)));

        for(int[] point : points){
            queue.offer(point);
        }

        int[][] result = new int[k][2];

        for(int i = 0; i<k; i++){
            int[] nums = queue.poll();
            result[i][0] = nums[0];
            result[i][1] = nums[1];
        }

        return result;
        
    }

    private int distance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }

}