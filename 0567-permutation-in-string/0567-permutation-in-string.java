class Solution {
    public boolean checkInclusion(String s1, String s2) {
        

            
        

        
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        
        int need = map.size();
        int left = 0;
        
        //  s1 = ab
        //  s2 = eidbiaooo 
        
        
       // s1 = ab
        //s2 = ffffaiba
         
        for(int right = 0; right < s2.length(); right++){
            
            char rightChar = s2.charAt(right);
            
            if(map.containsKey(rightChar)){
                map.put(rightChar, map.get(rightChar)-1); //we hit the character  
                if(map.get(rightChar) == 0){
                    need -= 1;
                }     
            }
            
            
            
            while(need == 0){
                
                if(right - left + 1 == s1.length()) return true;  

                char leftChar = s2.charAt(left);
                
                if(map.containsKey(leftChar)){
                    map.put(leftChar, map.get(leftChar) + 1);
                    if(map.get(leftChar) > 0){
                        need += 1;
                        
                    }
                        
             
                }
                left++;
            }
        }
            
        return false;
        
    }
}