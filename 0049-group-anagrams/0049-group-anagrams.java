class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            String original = str;
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = new String(charArr);
            if(map.containsKey(key)){
                map.get(key).add(original);
            }else{
                map.put(key, new ArrayList<>());
                map.get(key).add(original);
            }
        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            result.add(new ArrayList<>(entry.getValue()));
        }


        return result;


    }
}