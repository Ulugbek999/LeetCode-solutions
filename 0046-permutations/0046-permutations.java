class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(result, subset, nums);
        return result;
    }

    private List<Integer> available(List<Integer> subset, int[] nums){
        List<Integer> result = new ArrayList<>();

        for(int num : nums){
            if(subset.contains(num) == false){
                result.add(num);
            }
        }

        return result;
    }


    private void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums){

        //System.out.println(subset);
        if(subset.size() == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        for(Integer num : available(subset, nums)){
            subset.add(num);
            backtrack(result, subset, nums);
            subset.remove(subset.size() - 1);
        }


    }
}