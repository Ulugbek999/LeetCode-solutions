class Solution {
    public int scoreOfString(String s) {
        
        
        int val = 0;
        
        for(int i = 1; i<s.length(); i++){
            val += Math.abs(s.charAt(i) - s.charAt(i-1));
        }
            
            
        return val;
    }
}