class Solution {
    public List<String> removeAnagrams(String[] words) {

        List<String> result = new ArrayList<>();

        Set<String> set = new HashSet<>();
        result.add(words[0]);

        for(int i = 1; i<words.length; i++){
            
            char[] c1 = words[i-1].toCharArray();
            char[] c2 = words[i].toCharArray();

            Arrays.sort(c1);
            Arrays.sort(c2);

            String s1 = new String(c1);
            String s2 = new String(c2);
            
            if(s1.equals(s2)){
                continue;
            }else{
                result.add(words[i]);
            }

        }


        return result;
        
    }
}