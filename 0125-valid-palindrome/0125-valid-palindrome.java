class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        if(s.length() == 0 | s.length() == 1) return true;


        char[] charArr = s.toCharArray();
        for(char c : charArr){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }

        int left = 0;
        int right = sb.length()-1;

        while(left < right){
            if(sb.charAt(left) != sb.charAt(right)) return false;

            left++;
            right--;
        }


        return true;





    }
}