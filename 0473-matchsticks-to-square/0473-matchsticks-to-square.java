public class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int sideLength = sum / 4;

        int[] sides = new int[4];
        return dfs(matchsticks, sides, 0, sideLength);
    }

    private boolean dfs(int[] matchsticks, int[] sides, int i, int sideLength) {
        // for(int num : sides){
        //     System.out.print(num + " ");
        // }System.out.println();
        
        if (i == matchsticks.length) {
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }

        for (int j = 0; j < 4; j++) {
            if(sides[j] + matchsticks[i] <= sideLength){
                sides[j] += matchsticks[i];
                if(dfs(matchsticks, sides, i+1, sideLength)) return true;
                sides[j] -= matchsticks[i];
            }


            //if(sides[j] == 0) break;
        }
        return false;
    }

    private int[] reverse(int[] nums){

        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return nums;

    }
}