class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(String key : strs){
            char[] sortedKey = key.toCharArray();
            Arrays.sort(sortedKey);
            String sortedKeyStr = String.valueOf(sortedKey);

            if(map.containsKey(sortedKeyStr)){
                map.get(sortedKeyStr).add(key);
            }else{
                map.put(sortedKeyStr, new ArrayList<>());
                map.get(sortedKeyStr).add(key);
            }

        }

        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }
    
        return result;
    }
}