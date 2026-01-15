class Solution{

    public Solution(){

    }

    public int countSubstrings(String s) {

        int count = 0;

        for(int i = 0; i<s.length(); i++){
            count+= isPalindrome(s, i, i);
            count+= isPalindrome(s, i, i + 1);
        }

        return count;
    }


    private int isPalindrome(String s, int left, int right){
        int ct = 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            ct++;
            left--;
            right++;
        }
        
        return ct;
    }
}  