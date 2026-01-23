class Solution {
    public String largestGoodInteger(String num) {

        int left = 0;
        int lengthCount = 0;
        String[] results = new String[num.length()];
        int i = 0;

        for(int right = 1; right < num.length(); right++){

            if(num.charAt(right) != num.charAt(right-1)){
                left = right;
                lengthCount = 0;
            }

            if(num.charAt(right) == num.charAt(right-1)){
                lengthCount++;
            }

            if(lengthCount == 2){

                results[i++] = num.substring(left, right+1);
                left = right;
                lengthCount = 0;
            }
        }

        int maxString = 0;
        for(String nums : results){
            if(nums == null) continue;
            int n = Integer.parseInt(nums);
            maxString = Math.max(n, maxString);
        }

        for(String nums : results){
            if(nums == null) continue;
            if(maxString == Integer.parseInt(nums)){
                return nums;
            }
        }

        return new String();
        
    }
}