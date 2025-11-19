class Solution{

    public List<String> generateParenthesis(int n) {
        
        List<String> result = new ArrayList<>();

        StringBuilder substring = new StringBuilder();
        backtrack(result, substring, n, 0, 0);
        return result;

    }



    private void backtrack(List<String> result, StringBuilder sb, int n, int left, int right){
        // System.out.println(sb.toString());
        if(left == n && right == n){
            result.add(sb.toString());
            return;
        }

        if(left < n){
            sb.append('(');
            backtrack(result, sb, n, left+1, right);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(right < left){
            sb.append(')');
            backtrack(result, sb, n, left, right+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}