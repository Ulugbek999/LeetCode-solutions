class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        int l = 0;
        int r = people.length - 1;
        int boats = 0;
        Arrays.sort(people);
    
        while(l <= r){
            int remaining = limit - people[r--];
            boats++;
            if(l <= r && remaining >= people[l]){
                l++;
            }
        }
        return boats;
    }
}