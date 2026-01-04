class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        backtrack(list, nums, 0, sub);
        return list;
        
    }

public List<Integer> helper(int[] nums, List<Integer> sub) {
    Map<Integer, Integer> total = new HashMap<>();
    Map<Integer, Integer> used = new HashMap<>();

    for (int n : nums) {
        total.put(n, total.getOrDefault(n, 0) + 1);
    }

    for (int n : sub) {
        used.put(n, used.getOrDefault(n, 0) + 1);
    }

    List<Integer> result = new ArrayList<>();

    for (int n : total.keySet()) {
        int remain = total.get(n) - used.getOrDefault(n, 0);
        for (int i = 0; i < remain; i++) {
            result.add(n);
        }
    }

    return result;
}

    public void backtrack(List<List<Integer>> list, int[] nums, int i, List<Integer> sub){
        // System.out.println(sub);
        if(sub.size() == nums.length && !list.contains(sub)){

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