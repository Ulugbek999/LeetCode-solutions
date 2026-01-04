
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(result, subset, 0, nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> subset, int i, int[] nums){

        if(i >= nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[i]);
        backtrack(result, subset, i+1, nums);
        subset.remove(subset.size()-1);
        backtrack(result, subset, i+1, nums);
    }
}