class Solution {
    public int leastInterval(char[] tasks, int n) {
        

        int[] taskArr = new int[26];
        for(char task : tasks){
            taskArr[task - 'A']++;
        }

        Arrays.sort(taskArr);
        int maxChar = taskArr[25]-1;
        int idleSlots = maxChar * n;
        for(int i = 24; i>= 0; i--){
            idleSlots -= Math.min(taskArr[i], maxChar);
        }
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}

