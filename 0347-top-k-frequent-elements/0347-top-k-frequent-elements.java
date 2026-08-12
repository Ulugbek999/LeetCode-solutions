class Solution {
    public int[] topKFrequent(int[] nums, int k) {


        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //System.out.println(map);

        Comparator<Map.Entry<Integer, Integer>> sortBasedOnFrequency = Comparator.comparingInt((Map.Entry<Integer, Integer> entry) -> entry.getValue()).reversed();

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(sortBasedOnFrequency);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            queue.offer(entry);
        }
        int[] result = new int[k];
        int i = 0;
        while(i < k){
            result[i++] = queue.poll().getKey();
        }

        return result;

        
    }
}