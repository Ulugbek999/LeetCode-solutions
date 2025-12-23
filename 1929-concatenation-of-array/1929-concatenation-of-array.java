class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int newN = n * 2;

        int[] ans = new int[newN];

        for(int i = 0; i<nums.length; i++){
            ans[i] = nums[i];
        }
        // for(int num : ans){
        //     System.out.print(num + " ");
        // }

        int counter = 0;
        for(int i = nums.length; i<newN; i++){
            ans[i] = ans[counter];
            counter++;
        }

        return ans;


    }
}