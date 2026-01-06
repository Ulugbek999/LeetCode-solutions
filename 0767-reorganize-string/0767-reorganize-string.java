class Solution {
    public String reorganizeString(String s) {

        // System.out.println(s);
        
        Map<Character, Integer> map = new HashMap<>();
        Comparator<Map.Entry<Character, Integer>> byFreq = Comparator.comparing((Map.Entry<Character, Integer> entry) -> entry.getValue()).reversed();
        Queue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(byFreq);
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            queue.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;

        while(!queue.isEmpty()){
            Map.Entry<Character, Integer> entry  = queue.poll();
            char key = entry.getKey();
            int value = entry.getValue();
            sb.append(key);
            value -= 1;

            if(prev != null && prev.getValue() > 0){
                queue.offer(prev);
            }
            
            if(value > 0){
                prev = new java.util.AbstractMap.SimpleEntry<>(key, value);
                // queue.offer(new java.util.AbstractMap.SimpleEntry<>(key, value));
            }else{
                prev = null;
            }
        }


        if(prev == null){
            return sb.toString();
        }else{
            return new String();
        }

        // String result = sb.toString();
        // for(int i = 1; i<result.length(); i++){
        //     if(result.charAt(i) == result.charAt(i-1)){
        //         return "";
        //     }
        // }


        // return result;
    }
}