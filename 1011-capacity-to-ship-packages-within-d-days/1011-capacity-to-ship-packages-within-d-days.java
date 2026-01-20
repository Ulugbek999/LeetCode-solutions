class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int heaviest = 0;

        int sum = 0;
        for(int num : weights){
            sum+=num;
            heaviest = Math.max(heaviest, num);
        }

        //our solution is in between [heaviest <-> sum];
        //minimum -> heaviest, max -> sum;
        //int result = Integer.MAX_VALUE;

        int left = heaviest;
        int right = sum;
        int capacity = (left + right)/2;
        
        while(left < right){
            capacity = (left + right)/2;
            int runningSum = 0;
            int shipments = 1;
            for(int num : weights){

                if(runningSum + num > capacity){
                    runningSum = 0;
                    shipments++;
                }   
                runningSum += num;
            }
            if(shipments > days){
                left = capacity+1;
            }else{
                right = capacity;
                //result = Math.min(capacity, result);
            }

        }
        return left;
    }

    
}