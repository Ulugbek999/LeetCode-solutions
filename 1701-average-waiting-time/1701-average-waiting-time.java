class Solution {
    public double averageWaitingTime(int[][] customers) {

        double runningTime = 0;
        double[] waitingTime = new double[customers.length];
        int i = 0;

        for(int[] cust : customers){
            double arrivalTime = (double)cust[0];
            double complTime = (double)cust[1];

            if(arrivalTime >= runningTime){
                runningTime = arrivalTime;
                waitingTime[i] = complTime + runningTime - arrivalTime;
                i++;
                runningTime+=complTime;
            }else{
                double wait = runningTime - arrivalTime;
                waitingTime[i] = wait + complTime;
                runningTime += complTime;
                i++;
            }
        }

        // for(double num : waitingTime){
        //     System.out.println(num);
        // }

        double result = Arrays.stream(waitingTime).sum()/customers.length;


        return result;
    }
}