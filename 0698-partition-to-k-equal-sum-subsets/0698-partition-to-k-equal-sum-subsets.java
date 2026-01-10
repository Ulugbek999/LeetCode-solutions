class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = Arrays.stream(nums).sum();
        int limit = sum/k;
        if(sum % k != 0) return false;

        Arrays.sort(nums);
        reverse(nums);

        int[] sub = new int[k];
    
        return dfs(nums, sub, k, 0, limit);
    }


    private boolean dfs(int[] nums, int[] sub,int k, int i, int limit){
        // for(int num : sub){
        //     System.out.print(num + " ");
        // }System.out.println();

        if(i == nums.length){
            return true;
        }

        for(int j = 0; j<k; j++){
            if(sub[j] + nums[i] <= limit){
                sub[j] += nums[i];
                if(dfs(nums, sub, k, i+1, limit)) return true;
                sub[j] -= nums[i];
            }

            if(sub[j] == 0) break;
        }
        return false;
    }

    private int[] reverse(int[] nums){

        int l = 0;
        int r = nums.length-1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return nums;
    }
}