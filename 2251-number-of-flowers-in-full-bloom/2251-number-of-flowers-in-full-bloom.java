class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        
        //int[] result = new int[people.length];
        //Comparator sorter = Comparator.comparing((int[] nums) -> nums[0]);
        //Arrays.sort(flowers, sorter);

        int[] startTimes = new int[flowers.length];
        int[] endTimes = new int[flowers.length];
        for(int i = 0; i<flowers.length;i++){
            startTimes[i] = flowers[i][0];
            endTimes[i] = flowers[i][1];
        }
        int[] result = new int[people.length];
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int currentBlooming = 0;
        int j = 0;
        for(int person : people){
            
            int starts = helper(startTimes, person);
            int ends = helper2(endTimes, person);

            result[j++] = starts - ends;


            //System.out.println(starts + "   " + ends);



            // for(int start : startTimes){
            //     if(person >= start){
            //         count++;
            //     }
            // }

            // for(int end : endTimes){
            //     if(person > end){
            //         count--;
            //     }
            // }

            // result[j++] = count;
        }

        return result;
    }


    private int helper2(int[] endTimes, int currentTime){
        int left = 0;
        int right = endTimes.length;

        while(left < right){
            int mid = left + (right - left)/2;

            if(endTimes[mid] < currentTime){
                left = mid + 1;
            }else if(endTimes[mid] >= currentTime){
                right = mid;
            }
            
        }

        return left;
    }

    private int helper(int[] startTimes, int currentTime){
        
        int left = 0;
        int right = startTimes.length;
  
        while(left < right){
            
            int mid = left + (right - left)/2;
            
            if(startTimes[mid] > currentTime){
                right = mid;
            }else if(startTimes[mid] <= currentTime){
                left = mid+1;
            }

        }
        return left;

    }



}