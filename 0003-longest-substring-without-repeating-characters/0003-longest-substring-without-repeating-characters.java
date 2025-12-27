class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left = 0;
        
        int maxLength = 0;
        
        
        Set<Character> set = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            
            char rightChar = s.charAt(i);
            System.out.println(set);
            
            while(set.contains(rightChar)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(rightChar);
            
            if(maxLength < i - left + 1){
                maxLength = i - left + 1;
            }
            
        }

        return maxLength;
    }
}