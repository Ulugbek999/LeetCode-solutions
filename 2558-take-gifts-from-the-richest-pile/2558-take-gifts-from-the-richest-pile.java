class Solution {
    public long pickGifts(int[] gifts, int k) {

        //return the # of gifts remaining after k seconds.
        // do this to the choosen pike -> Reduce the number of gifts in the pile to the floor of the square root of the original number of gifts in the pile.

        Comparator<Integer> sorter = Comparator.comparing(num -> num);
        Queue<Integer> pq = new PriorityQueue<>(sorter.reversed());

        for(int num : gifts){
            pq.offer(num);
        }

        for(int i = 0; i<k;i++){
            double curr = (double)pq.poll();
            double reduced = Math.floor(Math.sqrt(curr));
            pq.offer((int)reduced);
        }

        long result = 0;

        while(!pq.isEmpty()){
            result += pq.poll();
        }


        return result;
    }
}