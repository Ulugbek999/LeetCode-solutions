class Solution {

    public String longestCommonPrefix(String[] strs) {

        String sub = strs[0];

        for(int i = 0; i<strs.length; i++){

            int j = 0;
            while(j < Math.min(sub.length(), strs[i].length())){
                if(sub.charAt(j) != strs[i].charAt(j)){
                    break;
                }
                j++;
            }
            sub = sub.substring(0, j);
        }


        return sub;
    }

}