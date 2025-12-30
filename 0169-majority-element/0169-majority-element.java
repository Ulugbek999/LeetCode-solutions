class Solution {
    public int majorityElement(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int val = 0;
        int key = 0;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            
            if(entry.getValue() > val){
                val = entry.getValue();
                key = entry.getKey();
            }

        }

        return key;

    }
}