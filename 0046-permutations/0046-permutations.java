class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, nums, 0, new ArrayList<>());
        return list;
    }

    public List<Integer> helper(int[] nums, List<Integer> current){
        List<Integer> result = new ArrayList<>();
        for(int num : nums){
            if(current.contains(num) == false){
                result.add(num);
            }
        }
        return result;

    }

    public void backtrack(List<List<Integer>> list, int[] nums, int i, List<Integer> sub){

        if(sub.size() == nums.length){
            list.add(new ArrayList<>(sub));
            return;
        }

        if(i >= nums.length) return;


        for(int num : helper(nums, sub)){
            sub.add(num);
            backtrack(list, nums, i+1, sub);
            sub.remove(sub.size() - 1);
        }


    }
}