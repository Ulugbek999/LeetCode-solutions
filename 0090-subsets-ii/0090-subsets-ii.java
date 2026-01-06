class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(nums);
        
        backtrack(result, sub, nums, 0);
        
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int i){

        if(i >= nums.length){
            if(result.contains(subset) == false){
                result.add(new ArrayList<>(subset));
            }
            return;
        }


        subset.add(nums[i]);
        backtrack(result, subset, nums, i+1);
        subset.remove(subset.size() - 1);
        backtrack(result, subset, nums, i+1);
    }
}