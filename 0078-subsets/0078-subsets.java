

class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        dfs(subset, 0, result, nums);

        return result;
    }

    private void dfs(List<Integer> subset, int counter, List<List<Integer>> result, int[] nums){

        if(counter >= nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[counter]);
        dfs(subset, counter+1, result, nums);
        subset.remove(subset.size()-1);
        dfs(subset, counter+1, result, nums);

    }

}