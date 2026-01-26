class Solution {
    public int takeCharacters(String s, int k) {


        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        if(k == 0 && s.length() > 0){
            return 0;
        }
        if(map.containsKey('a') == false || map.containsKey('b') == false || map.containsKey('c') == false){
            return -1;
        
        }

        //if the frequency of any of the characters is < k, then it is impossible to solve it:
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            
         
            if(entry.getValue() < k){
                return -1;
            }
        }

        int res = Integer.MAX_VALUE;
        int left = 0;

        for(int right = 0; right<s.length(); right++){
            char rightChar = s.charAt(right);
            map.put(rightChar, map.get(rightChar)-1);
            
            while(Math.min(Math.min(map.get('a'), map.get('c')) , map.get('b')) < k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar)+1);
                left++;
            }

            res = Math.min(res, s.length() - (right - left + 1));
        
        }

        return res;

    }


    // private boolean helper(Map<Character, Integer> map, int k){

    //         if((!map.containsKey('a') || !map.containsKey('b') || !map.containsKey('c') || !(map.get('a') < k || map.get('b') < k || map.get('c') < k))){
    //             return true;
    //         }

    //         return false;

    // }



}