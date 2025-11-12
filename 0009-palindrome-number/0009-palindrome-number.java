class Solution {
    public boolean isPalindrome(int x) {

        String num = Integer.toString(x);
        char[] charNum = num.toCharArray();

        int a = 0;
        int b = charNum.length-1;

        while(a<=b){
            if(charNum[a] == charNum[b]){
                a++;
                b--;
            }else{
                return false;
            }
        }

        return true;


        
    }
}