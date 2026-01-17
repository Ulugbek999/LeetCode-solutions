class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        
        StringBuilder sb = new StringBuilder();
        int minWord = Integer.MAX_VALUE;
        
        for(String str : strs){
            minWord = Math.min(minWord, str.length());
        }
        
        
        for(int i = 0; i < minWord; i++){
            
            for(int j = 0; j < strs.length; j++){
                if(strs[0].charAt(i) != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        
        //["ab", "a"]
        return sb.toString();
    }
}


