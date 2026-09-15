class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }


    private void backtrack(List<List<Integer>> result, List<Integer> sublist, int[] nums){

        if(sublist.size() == nums.length){
            result.add(new ArrayList<>(sublist));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(sublist.contains(nums[i])){
                continue;
            }
            sublist.add(nums[i]);
            backtrack(result, sublist, nums);
            sublist.remove(sublist.size() - 1);
        }
    }
}