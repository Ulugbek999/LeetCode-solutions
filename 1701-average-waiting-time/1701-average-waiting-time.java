class Solution {
    public double averageWaitingTime(int[][] customers) {
        
        double sumOfWait = (double)customers[0][1];
        double finishTime = customers[0][0] + sumOfWait;

        for(int i = 1; i<customers.length;i++){
            int arrival = customers[i][0];
            int wait = customers[i][1];
            int newWait = wait;
            if(finishTime > arrival){
                newWait+= (finishTime - arrival);
            }
            
            finishTime = Math.max(finishTime, arrival) + wait;
            sumOfWait += newWait;

        }   

        return sumOfWait/customers.length;
    }
}








