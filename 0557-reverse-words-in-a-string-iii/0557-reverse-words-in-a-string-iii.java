class Solution {
    public String reverseWords(String s) {
        
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            // System.out.println(str);
            int l = 0;
            int r = str.length()-1;
            char[] charArr = str.toCharArray();
            while(l < r){
                char temp = charArr[l];
                charArr[l] = charArr[r];
                charArr[r] = temp;

                l++;
                r--;
            }
            String res = new String(charArr);
            sb.append(res);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }
}