class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        
    
    List<List<Integer>> lists = new ArrayList<>();
    
    int left = 0;
    int currentProd = 1;
    int count = 0;
    
    for(int right = 0; right < nums.length; right++){
        
        int rightNum = nums[right];
        
        currentProd *= rightNum;
          
        while(currentProd >= k && left < right){
            currentProd /= nums[left];
            left++;
        }

        if(currentProd<k){
            count += right - left + 1;
        } 
        
    }
    
        
    return count;
        
        
    }
}