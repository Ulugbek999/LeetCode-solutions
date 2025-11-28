class Solution {
    public int arrayPairSum(int[] nums) {
        //int numberOfPair = nums/2;
        int currentSum = 0;

        Arrays.sort(nums);

        for(int i = 0; i<nums.length; i+=2){
            int a = nums[i];
            int b = nums[i+1];
            currentSum += Math.min(a, b);
        }

        return currentSum;


    }
}