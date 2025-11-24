

class Solution {


    public int maximumPopulation(int[][] logs) {

        int[] years = new int[2051 - 1950 + 1];
      
        // for(int year : years) System.out.println(year);


        for(int[] log : logs){
            int birth = log[0] - 1950;
            int death = log[1] - 1950;

            //System.out.println("birth = " + birth + " death = " + death);

            years[birth] += 1; //person appears
            years[death] -= 1; //person dies
        }

        int maxPop = 0;
        int currentPop = 0;
        int resultYear = 0;


        for(int i = 0; i < years.length; i++){
            currentPop += years[i];

            if(currentPop > maxPop){
                maxPop = currentPop;
                resultYear = i+1950;
            }
        }

        return resultYear;

    }
}