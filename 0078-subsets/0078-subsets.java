

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        //System.out.println(result);
        return result;

    }


    public void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int start){

        //System.out.println(subset);
        
        if(start == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

        if(start == nums.length){
            return;
        }

        subset.add(nums[start]);
        backtrack(result, subset, nums, start+1);
        subset.remove(subset.size() - 1);
        backtrack(result, subset, nums, start+1);

    }
}