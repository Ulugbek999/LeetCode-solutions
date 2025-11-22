class Solution {
    public List<String> letterCombinations(String digits) {


        Map<Character, String> map = new HashMap<>();
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");


        List<String> result = new ArrayList<>();
        char[] nums = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        backtrack(result, nums, map, sb, 0);

        return result;
    }



    public void backtrack(List<String> result, char[] nums, Map<Character, String> map, StringBuilder sb, int counter){

        if(counter >= nums.length){
            result.add(sb.toString());
            return;
        }

        // for(char num : nums){

        //     String letters = map.get(num);
        //     char[] chars = letters.toCharArray();

        //     sb.append(chars[counter]);
        //     backtrack(result, nums, map, sb, counter+1);
        //     sb.deleteCharAt(sb.length() - 1);

        // }

        char digit = nums[counter];
        String letters = map.get(digit);
        char[] chars = letters.toCharArray();

        for(char c : chars){
            sb.append(c);
            backtrack(result, nums, map, sb, counter+1);
            sb.deleteCharAt(sb.length() - 1);
        }




    }





}