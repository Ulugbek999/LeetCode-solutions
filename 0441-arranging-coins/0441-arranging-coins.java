class Solution {
    public int arrangeCoins(int n) {
        


        int right = n;
        int left = 1;

        int result = 0;

        while(left <= right){
            int mid = left + (right - left)/2;

            long coins = (long) mid * (mid + 1) / 2;            
            if(coins > n){
                right = mid-1;
            }else{
                left = mid + 1;
                result = Math.max(mid, result);
            }
            
        }

        return result;

    }
}