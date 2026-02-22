class Solution {
    public int searchInsert(int[] nums, int target) {

        if(target > nums[nums.length-1]) return nums.length;


        int left = 0;

        int right = nums.length - 1;
        int mid = left + (right - left)/2;


        while(left < right){

            mid = left + (right - left)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;

    }
}