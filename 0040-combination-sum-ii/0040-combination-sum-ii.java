class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        
        backtrack(result, subset, target, 0, candidates);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> subset, int target, int counter, int[] candidates){
        System.out.println(subset);
        if(target == 0){
            
            
            result.add(new ArrayList<>(subset));
            return;
        }

        if(target < 0 || counter >= candidates.length){
            return;
        }


        //Struggled with this part + Mr.GPT helped out here ->
        //Main problem was that I kept getting duplicates like say target == 8, I kept getting [2, 2, 4] and [4, 2, 2] type of duplicates being added to the result;

        // OPTION 1: CHOOSE the current element
        subset.add(candidates[counter]);
        backtrack(result, subset, target - candidates[counter], counter + 1, candidates);
        subset.remove(subset.size() - 1);

        // OPTION 2: SKIP THE CURRENT ELEMENT
        // But skip all duplicates of this element
        int next = counter + 1;
        while (next < candidates.length && candidates[next] == candidates[counter]) {
            next++;
        }

        backtrack(result, subset, target, next, candidates);


    }


}