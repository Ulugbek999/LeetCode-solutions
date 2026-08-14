class Solution {
    public int search(int[] nums, int target) {

        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }else{
                return -1;
            }
        }

        int pivot = 0;
        
        for(int i = 1; i<nums.length; i++){
            if(nums[i] < nums[i-1]){
                pivot = i;
                break;
            }
        }

        if(pivot == 0){
            int left = 0;
            int right = nums.length -1;
            while(left <= right){


            int mid = left + (right - left) / 2;

                if (target > nums[mid]) {
                    // target is bigger, so search RIGHT half
                    left = mid + 1;

                } else if (target < nums[mid]) {
                    // target is smaller, so search LEFT half
                    right = mid-1;

                } else {
                    return mid;
                }
            }
            return -1;
        }

        //now binary search depending on whether the number in the first half or the seceond half;
        if(target >= nums[pivot] && target <= nums[nums.length-1]){
            //its in the second half
            int left = pivot;
            int right = nums.length-1;
            while(left <= right){

                int mid = left + (right - left)/2;
                
                if (target > nums[mid]) {
                    // target is bigger, so search RIGHT half
                    left = mid + 1;

                } else if (target < nums[mid]) {
                    // target is smaller, so search LEFT half
                    right = mid - 1;

                } else {
                    return mid;
                }
            }
        }else if(target >= nums[0] && target <= nums[pivot - 1]){
            //then it is on the left side
            int left = 0;
            int right = pivot - 1;

            while(left <= right){
                int mid = left + (right - left)/2;
                if(target > nums[mid]){
                    left = mid + 1;
                }else if(target < nums[mid]){
                    right = mid-1;
                }else{
                    return mid;
                }
            }
        }else if(target == nums[pivot]){
            return pivot;
        }

        return -1;
    }
}