class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c : ransomNote.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : magazine.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) +1);
        }

        for(char c : ransomNote.toCharArray()){
            if(!map2.containsKey(c) || map2.get(c) < map.get(c)) return false;
        }
        return true;
    }
}