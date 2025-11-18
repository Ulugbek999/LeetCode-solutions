class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[n];
        for(int i = 0; i<n; i++){
            nums[i] = i+1;
        }


        backtrack(result, new ArrayList<>(), nums, k, 0);

        return result;

    }


    // private List<Integer> otherOptions(List<Integer> state, int[] nums){
    //     List<Integer> options = new ArrayList<>();
    //     for(int num : nums){
    //         if(!state.contains(num)){
    //             options.add(num);
    //         }
    //     }
    //     return options;
    // } 


    private void backtrack(List<List<Integer>> result, List<Integer> state, int[] nums, int k, int counter){
        // System.out.println(state);
        if(state.size() == k){
            // List<Integer> sorted = new ArrayList<>(state);
            // Collections.sort(sorted);
            // if(!result.contains(sorted))
            result.add(new ArrayList<>(state));
            
            return;
        }


        if(counter >= nums.length){
            return;
        }

        state.add(nums[counter]);
        backtrack(result, state, nums, k, counter+1);
        state.remove(state.size() - 1);
        backtrack(result, state, nums, k, counter+1);
    
        // for(int option : otherOptions(state, nums)){

        //     state.add(option);
        //     backtrack(result, state, nums, k);
        //     state.remove(state.size() - 1);
        // }

    }

}