class Solution {

    public char findTheDifference(String s, String t) {

        int[] freq = new int[26];
        for(char c : t.toCharArray()){
            freq[c-'a']++;
        }
        for(char c : s.toCharArray()){
            freq[c-'a']--;
        }

        for(int num = 0; num < 26; num++){
            if(freq[num] == 1){
                return (char)(num + 'a');
            }
        }
        return ' ';
    }
}