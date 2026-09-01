class Solution {

    int counter = 0;

    public int beautifulSubsets(int[] nums, int k) {
        
        backtrack(nums, new ArrayList<>(), k, 0);
        return counter;
        
    }

    public void backtrack(int[] nums, List<Integer> list, int k, int i){

        if(i >= nums.length){
            // System.out.println(list);
            // System.out.println(isBeautiful(list, k));
            if(isBeautiful(list, k)){
                counter = counter + 1;
                //System.out.println(counter);
            }
            return;
        }

        list.add(nums[i]);
        backtrack(nums, list, k, i+1);
        list.remove(list.size()-1);
        backtrack(nums, list, k, i+1);

    }

    public boolean isBeautiful(List<Integer> list, int target){
        if(list.size() == 0) return false;

        if(list.size() == 1) return true;

        if(list.size() == 2){
            if(Math.abs(list.get(0) - list.get(1)) == target){
                return false;
            }else{
                return true;
            }
        }

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i<list.size(); i++){
            
            int compliment1 = list.get(i) - target;
            int compliment2 = list.get(i) + target;
            //use a set
            if(set.contains(compliment1) || set.contains(compliment2)){
                return false;
            }
            set.add(list.get(i));
        }

        return true;
    }
}