class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subArray = new ArrayList<>();
        backtrack(result, subArray, target, candidates, 0);
        return result;
    }


    private void backtrack(List<List<Integer>> result, List<Integer> subArray, int target, int[] candidates, int i){
        if(target == 0){
            result.add(new ArrayList<>(subArray));
            return;
        }
        
        if(target < 0 || i >= candidates.length){
            return;
        }

        subArray.add(candidates[i]);
        backtrack(result, subArray, target - candidates[i],candidates, i);
        subArray.remove(subArray.size() - 1);
        backtrack(result, subArray, target, candidates, i+1);


        






    }
}