class Solution {
    public void sortColors(int[] nums) {
        //if(nums.length <= 1) return;

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //System.out.println(map);
        int counter = 0;

        // for(int i = 0; i<map.size(); i++){
        //     if(map.get(i)!= null){
        //         while(map.get(i) > 0){
        //             nums[counter] = i;
        //             map.put(i, map.get(i)-1);
        //             counter++;
        //         }
        //     }

        // }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            int key = entry.getKey();
            int value = entry.getValue();

            for(int i = 0; i < value; i++){
                nums[counter++] = key;
            }

        }

        

    }
}