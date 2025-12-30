class Solution {
    public int removeElement(int[] nums, int val) {
        int counter = 0;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == val) {
                nums[i] = Integer.MAX_VALUE;
            }else{
                counter++;
            }
        }

        // for(int i = 0; i<nums.length; i++){
        //     for(int j = i + 1; j<nums.length; j++){




        //     }
        // }
        Arrays.sort(nums);

        return counter;

        
    }
}