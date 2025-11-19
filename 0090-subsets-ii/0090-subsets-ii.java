class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, result, subset, 0);
        return result;
        
    }


    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> subset, int i){

        if(i >= nums.length){
            if(!result.contains(new ArrayList<>(subset))){
                result.add(new ArrayList<>(subset));
            }

            return;
        }

        subset.add(nums[i]);
        backtrack(nums, result, subset, i+1);
        subset.remove(subset.size() - 1);
        backtrack(nums, result, subset, i+1);


    }
}