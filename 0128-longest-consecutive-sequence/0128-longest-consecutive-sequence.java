class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;


        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int maxSeq = 0;

        for(int num : set){

            
            //check to find the beginning of the sequenece:
            if(!set.contains(num-1)){
                //then it is the beginning
            
                int seq = 0;
                while(set.contains(num+1)){
                    seq++;
                    num++;
                }
                if(maxSeq < seq){
                    maxSeq = seq;
                }
            }

        }
        

        return maxSeq+1;

    }
}