class Solution {
    public String minWindow(String s, String t) {

        if(t.length() > s.length()) return "";

        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minLength = Integer.MAX_VALUE;
        int minStart = 0;


        int need = map.size();

        int left = 0; 

        for(int right = 0; right < s.length(); right++){

            if(map.containsKey(s.charAt(right))){

                map.put(s.charAt(right), map.get(s.charAt(right))-1);

                if(map.get(s.charAt(right)) == 0){
                    need -= 1;

                }
            }
            

            while(need == 0){

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);   

                    if(map.get(s.charAt(left)) > 0){
                    need++;
                }

                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) return "";

        return s.substring(minStart, minStart + minLength);

    }
}