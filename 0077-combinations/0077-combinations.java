class Solution {
    public List<List<Integer>> combine(int n, int k) {

        int[] nums = new int[n];
        int counter = 1;
        for(int i = 0; i<n; i++){
            nums[i] = counter++;
        }

        // for(int num : nums){
        //     System.out.println(num);
        // }

        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, nums, 0, k, new ArrayList<>());

        return list;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, int i, int k, List<Integer> sub){
        // System.out.println(sub);
        if(sub.size() == k){
            list.add(new ArrayList<>(sub));
            return;
        }

        if(i >= nums.length) return;

        sub.add(nums[i]);
        backtrack(list, nums, i+1, k, sub);
        sub.remove(sub.size() - 1);
        backtrack(list, nums, i+1, k, sub);

    }
}