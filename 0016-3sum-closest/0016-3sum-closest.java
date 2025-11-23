class Solution {

    public int threeSumClosest(int[] nums, int target) {


        int closest = nums[0] + nums[1] + nums[2];


        Arrays.sort(nums);

        for(int a = 0; a < nums.length - 2; a++){

            if(a > 0 && nums[a] == nums[a-1]) continue;

            int b = a + 1;
            int c = nums.length - 1;

            while(b < c) {
                int sum = nums[a] + nums[b] + nums[c];

                if(Math.abs(sum - target) < Math.abs(closest - target)){
                    closest = sum;
                } 

                if(sum < target){
                    b++;
                }else if(sum > target){
                    c--;
                }else {
                    return sum;
                }

            }
        }

        return closest;
    }
}