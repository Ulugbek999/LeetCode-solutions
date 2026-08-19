class Solution {

    int[][] jobs; //an array of arrays to keep each start->end->profit or each job
    int[] memo;//to store the max profit



    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = startTime.length; //a variable to have the number of jobs
        jobs = new int[n][3]; //

        for(int i = 0; i<n; i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }


        //sorting the jobs by startTime in ascending order
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));


        memo = new int[n];
        //Fill the memo with -1s initially, since the profit could potentially be = 0, hence why we are not filling the array with 0s.
        Arrays.fill(memo, -1);


        return  solve(0);
        
    }

    //recursive function that also uses memoization to find the highest possible profit
    private int solve(int i){

        //base case to stop the recursion
        if(i >= jobs.length){
            return 0;
        }

        if(memo[i] != -1){
            //means we have already computer this value before, return the value we have computed:
            return memo[i];
        }

        //two possible scenarios
        //case one: We skip the current value and go to the next one:
        int skip = solve(i+1);

        //case two: We take the current value and based on it, we add the next possible value:
        int next = nextAvailableJob(i);

        //take the max of each:
        int take = jobs[i][2] + solve(next);

        //memoize the maximum value
        memo[i] = Math.max(skip, take);

        
        return memo[i];

    }


    //binary search through the jobs to identify the next possible job, given that we selected the current job at i
    private int nextAvailableJob(int i){

        int currentEnd = jobs[i][1];//the end of the current job
        int right = jobs.length;
        int left = i + 1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(jobs[mid][0] >= currentEnd){
                right = mid;
            }else{
                left = mid + 1;
            }

        }

        return left;
        


    }



}