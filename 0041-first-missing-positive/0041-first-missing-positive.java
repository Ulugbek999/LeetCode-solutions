class Solution {
    public int firstMissingPositive(int[] nums) {

        int min = 1;
        int max = 0;
        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            max = Math.max(max, num);
            set.add(num);
        }


        for(int i = min; i<=max; i++){
            if(set.contains(i) == false && i > 0){
                return i;
            }
        }


        return max+1;
    }
}