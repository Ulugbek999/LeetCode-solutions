class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        
        for(int num : arr) list.add(num);

        list.sort((a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);
            if(diffA != diffB){
                return diffA - diffB;
            }
            return a - b;
        });

        List<Integer> result = list.subList(0, k);

        List<Integer> sorted = new ArrayList<>(result);
        Collections.sort(sorted);

        return sorted;

        
    }
}