class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        
        
        int result = 0;
        
        if(colors.length >= 3){
            if(colors[0] != colors[1] && colors[colors.length - 1] != colors[0]){
                    result+= 1;
                }
        }
        
        for(int i = 1; i < colors.length; i++){
            
            if(colors[i-1] != colors[i] && colors[i] != colors[(i+1)%colors.length]){
                result+=1;
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




