class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        
        
        int result = 0;
        int n = colors.length;
        //int right = 3;
        
        for(int mid = 0; mid < n; mid++){
            
            int left = colors[((mid-1)+n)%n];
            int curr = colors[mid];
            int right = colors[(mid+1)%n];
            
            if(curr != left && curr != right){
                result++;
            } 
        }
            
        return result;
        
    }
    
    
    // private boolean helper(int[] subArr){
        
    //     if(subArr[0] == subArr[2] && subArr[1] != subArr[0] && subArr[1] != subArr[2]){
    //         return true;
    //     }
        
    //     return false;
        
    // }
    

}




