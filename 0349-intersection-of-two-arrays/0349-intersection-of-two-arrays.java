class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        

        List<Integer> n1 = new ArrayList<>(); for(int n : nums1) n1.add(n);
        List<Integer> n2 = new ArrayList<>(); for(int n : nums2) n2.add(n);
        List<Integer> intersection = new ArrayList<>();

        for(int num : n2){
            if(n1.contains(num)){
                if(intersection.contains(num) == false){
                    intersection.add(num);
                }
            }
        }
        int[] result = new int[intersection.size()];
        for(int i = 0; i<result.length; i++){
            result[i] = intersection.get(i);
        }

        return result;
    }
}