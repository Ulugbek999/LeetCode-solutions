class Solution {
    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] ageFreq = new int[121];
        for (int age : ages) {
            ageFreq[age]++;
        }
        for (int age : ages) {
            //Adding 1 as (int)(0.5 * age) + 7 value is not inclusive
            int minValidAge = ((int)(0.5 * age) + 7) + 1;
            //y > x is an invalid case
            int maxValidAge = age;
            //Iterate through min and max valid ages and keep adding number of people with all such ages
            for (int j = minValidAge; j <= maxValidAge; j++) {
                res+= ageFreq[j];
                if (j == age) {
                    res--;
                }
            }
        }
        return res;
    }
}