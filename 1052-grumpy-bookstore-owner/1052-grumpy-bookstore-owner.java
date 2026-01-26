
class Solution {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
    
        
            int left = 0;
            int window = 0;
            int maxWindow = 0;
            int satisfied = 0;
            
            
            
            for(int right = 0; right < customers.length; right++){
                
                int isGrumpy = grumpy[right];
                
                if(isGrumpy == 1){
                    window += customers[right];
                }else{
                    satisfied += customers[right];
                }
                
                if(right - left + 1 > minutes){
                    
                    if(grumpy[left] == 1){
                        window -= customers[left];
                    }
                    
                    left++;
                }
                
                maxWindow = Math.max(maxWindow, window);

            }
            
            return maxWindow + satisfied;
        
        
    
        // int[] grumpyMax = new int[3];
        
        
        // while(right < customers.length){
                    
        //     if(windowSum(left, right, customers) > customerMax[0]){
        //         customerMax[0] = windowSum(left, right, customers);
        //         customerMax[1] = left;
        //         customerMax[2] = right;
        //     }
            
            
        //     if(windowSum(left, right, grumpy) > grumpyMax[0]){
        //         grumpyMax[0] = windowSum(left, right, grumpy);
        //         grumpyMax[1] = left;
        //         grumpyMax[2] = right;
        //     }
            
            
        //     left++;
        //     right++;                        
        // }
        
        //     int l = customerMax[1];
        //     int r = customerMax[2];
            
        //     for(int i = l+1; i<=r; i++){
        //         grumpy[i] = 0;
        //     }        

        
        // int result = 0;
        // for(int i = 0; i<customers.length; i++){
        //     if(grumpy[i] != 1){
        //         result += customers[i];
        //     }
        // }
        // return result;
        
    
    }
    
    private int windowSum(int left, int right, int[] arr){
        
        int sum = 0;
        
        while(left < right){
            sum += arr[left];
            left++;
        }
        
        return sum;
        
    }


}