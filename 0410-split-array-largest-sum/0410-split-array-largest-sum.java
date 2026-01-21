class Solution {
    public int splitArray(int[] nums, int k) {


        // if(nums.length == k){
        //     int max = 0;
        //     for(int num : nums){
        //         max = Math.max(num, max);
        //     } 
        //     return max;     
        // }

        //Step 1: Need to identify the the answer range, so:
        //whats the minimum possible sum:
        int sum = Arrays.stream(nums).sum();
        int left = sum/k; //this is the minimum

        int max = 0;
            for(int num : nums){
                max = Math.max(num, max);
            } 

        int right = sum;
        //now for each number in the range we need to see if we can make divisions of that size:

        while(left < right){

            int capacity = (right + left)/2;
            int divisions = check(capacity, nums);

            if(divisions > k){
                //then capacity was too low, so we need to increase:
                left = capacity+1;
            }else{
                right = capacity;
            }
        }

        return left < max ? max : left;
    }

    private int check(int capacity, int[] nums){
        int runningSum = 0;
        int divisions = 1;
        for(int num : nums){
            if(runningSum + num > capacity){
                runningSum = 0;
                divisions++;
            }
            runningSum += num;
        }
        return divisions;
    }
}