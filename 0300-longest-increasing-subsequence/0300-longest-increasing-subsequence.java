class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] lis = new int[nums.length];

        Arrays.fill(lis, 1);

        for(int i = nums.length-1; i>=0; i--){
            for(int j = i+1; j<nums.length;j++){
                if(nums[j] > nums[i]){
                    //System.out.println(nums[j] + " > " + nums[i]);

                    lis[i] = Math.max(lis[i], lis[j] + 1); 
                    //System.out.println(Math.max(lis[i], lis[j] + 1));
                }
            }
        }

        int result = 0;

        for(int num : lis){
            result = Math.max(num, result);
        }
        return result;
    }
}