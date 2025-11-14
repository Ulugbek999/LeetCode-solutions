class Solution {

    List<List<Integer>> result;


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(candidates, target, current, 0);
        return result;


    }




    private void backtrack(int[] nums, int target, List<Integer> current, int i){

        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }

        if(target < 0 || i >= nums.length){
            return;
        }

        current.add(nums[i]);
        backtrack(nums, target-nums[i], current, i);
        current.remove(current.size() - 1);
        backtrack(nums, target, current, i + 1);

    }



}