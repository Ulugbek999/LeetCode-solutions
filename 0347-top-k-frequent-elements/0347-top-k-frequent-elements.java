class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        if(nums.length == 0){
            return new int[]{};
        }

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing((Map.Entry<Integer, Integer> entry) -> entry.getValue()).reversed());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
        }

        int[] result = new int[k];
       
        int iterator = 0;
        while(iterator < k){
        // Map.Entry<Integer, Integer> entry  = pq.poll();
        // result[iterator] = entry.getKey();
        // // iterator++;
            result[iterator++] = pq.poll().getKey();
        }

        return result;
    }


}


