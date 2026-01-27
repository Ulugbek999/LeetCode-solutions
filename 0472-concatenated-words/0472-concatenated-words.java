class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> result = new ArrayList<>();
        Set<String> dict = new HashSet<>();

        for(String w : words){
            dict.add(w);
        }

        for(String word : words){

            boolean[] dp = new boolean[word.length() + 1];
            dp[word.length()] = true;

            for(int i = word.length()-1; i >= 0; i--){
                for(int j = i + 1; j<=word.length(); j++){

                    String sub = word.substring(i, j);

                    if(!sub.equals(word) && dict.contains(sub)){
                        dp[i] = dp[j];
                    }

                    if(dp[i]) break;
                }
            }

            if(dp[0]){
                result.add(word);
            }
        }

        return result;
    }
}