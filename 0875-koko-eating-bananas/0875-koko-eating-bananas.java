class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        for(int num : piles){
            right = Math.max(num, right);
        }
        int left = 1;
        int mid = 0;
        while(left < right){

            mid = (left + right)/2;
            int currentPace = check(mid, piles);
            if(currentPace > h){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    private int check(int mid, int[] piles){
        int hours = 0;

        for(int pile : piles){
            hours += (pile + mid - 1)/mid;
        }


        return hours;
    }



}