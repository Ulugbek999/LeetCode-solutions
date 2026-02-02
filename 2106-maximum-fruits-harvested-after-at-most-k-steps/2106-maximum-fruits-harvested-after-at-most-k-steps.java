class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        
        int maxFruits = 0;
        int currentSum = 0;


        int left = 0;

        for(int right = 0; right < fruits.length; right++){


            //Get position and fruit count at right pointer;
            int rightPosition = fruits[right][0];
            int rightFruits = fruits[right][1];

            //adding fruits at right position to current sum
            currentSum += rightFruits;

            //Shrink window from left while total distance exceeds k
            //Total distance = (straight distance) + (minimum turn-back distance)
            //we either go left first then right, or right first then left

            while(left <= right && rightPosition - fruits[left][0] + Math.min(Math.abs(startPos - fruits[left][0]), Math.abs(startPos - rightPosition)) > k){
                //remove fruits at left position and move left pointer
                currentSum -= fruits[left][1];
                left++;
            }

            maxFruits = Math.max(maxFruits, currentSum);
        }
        

        return maxFruits;

    }


}