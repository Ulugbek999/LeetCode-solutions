class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, s);

        return result;
        
    }

    private void backtrack(List<List<String>> result, List<String> part, int i, String s){

        if(i >= s.length()){
            result.add(new ArrayList<>(part));
            return;
        }

        for(int j = i; j<s.length(); j++){
            if(isPalindrome(s, i, j)){
                part.add(s.substring(i, j+1));
                backtrack(result, part, j+1, s);
                part.remove(part.size() - 1);
            }
        }
    }


    private boolean isPalindrome(String s, int l, int r){
        
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
                
            }else{
                l++;
                r--;
            }
        }

        return true;
    }


}