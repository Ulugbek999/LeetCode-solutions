class Solution {
    public int[] frequencySort(int[] nums) {

        Comparator<Map.Entry<Integer, Integer>> cmp = Comparator.comparing(Map.Entry<Integer, Integer> :: getValue);
        Comparator<Map.Entry<Integer, Integer>> cmp2 = Comparator.comparing(Map.Entry<Integer, Integer> :: getKey).reversed();

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(cmp.thenComparing(cmp2));

        int[] result = new int[nums.length];
        int j = 0;
        for(Map.Entry<Integer, Integer> entry : list){
            
            for(int i = 0; i<nums.length; i++){
                
                if(entry.getKey() == nums[i]){
                    result[j++] = entry.getKey();
                }
            }
        }

        return result;
    }
}