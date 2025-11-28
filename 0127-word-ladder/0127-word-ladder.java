class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        if(!set.contains(endWord)) return 0;

        int level = 1;
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        
        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i = 0; i<size; i++){
                String currentWord = queue.poll();
                char[] charArr = currentWord.toCharArray();
                for(int j = 0; j<charArr.length; j++){
                    char originalChar = charArr[j];
                    for(char c = 'a'; c<='z'; c++){
                        if(charArr[j] == c) continue;
                        charArr[j] = c;
                        String newWord = String.valueOf(charArr);
                        if(endWord.equals(newWord)) return level+1;
                        if(set.contains(newWord)){
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    charArr[j] = originalChar;
                }
            }
            level+=1;
        }
        return 0;
    }
}