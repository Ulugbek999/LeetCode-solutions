class Solution {


    public int subarraysWithKDistinct(int[] nums, int k) {
    

        int left = 0;
        int leftFar = 0;
        int count =0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int right = 0; right < nums.length; right++){

            int curr = nums[right];

            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while(map.size() > k){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
                leftFar = left;
            }

            while(map.get(nums[left]) > 1){
                map.put(nums[left], map.get(nums[left]) - 1);
                left++;
            }

            if(map.size() == k){
                count += left - leftFar + 1;
            }


        }

            return count;

    }
}