

class Solution {

    int[][] jobs;
    int[] memo;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int n = startTime.length;
        jobs = new int[n][3]; //[[start][end][profit]];

        for(int i = 0; i<n; i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        //Sorting the jobs by their start time
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        //memo -> an array to store maximum profti
        memo = new int[n];
        Arrays.fill(memo, -1); //cause 0 could be a legitimate answer;

        return solve(0);

    }

    private int solve(int i){
        //base case:
        if(i >= jobs.length){
            return 0;
        }

        if(memo[i] != -1){
            //then this subproblem has been already solved
            return memo[i];
        }

        //Option 1: SKIP the current job
        int skip = solve(i+1);

        //Otion 2: Take the current job
        int next = findNextJob(i);
        int take = jobs[i][2] + solve(next);

        memo[i] = Math.max(skip, take);

        return memo[i];

    }


    //binary search to find the next available job
    private int findNextJob(int i){


        int currentEnd = jobs[i][1];
        int left = i + 1;
        int right = jobs.length;

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