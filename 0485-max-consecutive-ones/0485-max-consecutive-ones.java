class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int maxNum = 0;
        int counter = 0;
        for(int num : nums){
            
            if(num == 1){
                counter++;
                maxNum = Math.max(counter, maxNum);
            }else{
                counter = 0;
            }
        }
        return maxNum;
    }
}