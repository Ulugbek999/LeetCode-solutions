


class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 1) return 1;
        
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;

        for(int right = 0; right < s.length(); right++){

            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
            }else{
                while(s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);




        }

        return maxLength;


    }
}