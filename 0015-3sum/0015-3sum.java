class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int a = 0; a < nums.length -2; a++){

            if (a > 0 && nums[a] == nums[a - 1]) continue;

            int b = a + 1;
            int c = nums.length - 1;

            while(b<c){

                int sum = nums[a] + nums[b] + nums[c];

                if(sum == 0){
                    result.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    b++;
                    c--;
                    while(b < c && nums[b] == nums[b-1]) b++;
                    while(b < c && nums[c] == nums[c + 1]) c--;
                } else if(sum < 0){
                    b++;
                }else{
                    c--;
                }
            }
        }

        return result;
    }
}