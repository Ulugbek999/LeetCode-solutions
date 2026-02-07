class Solution {

    public int maxSize = 0;
    public int minSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[nums.length - k + 1];
        int[] window = new int[k];

        //adding lazy deletion:
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<k; i++){
            window[i] = nums[i];
        }

        Comparator cp = Comparator.comparing((Integer num) -> num).reversed();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(cp);

        //BuildHeap here:
        for(int num : window){
            if(maxHeap.isEmpty() || num <= maxHeap.peek()){
                maxHeap.offer(num);
                maxSize++;
            }else{
                minHeap.offer(num);
                minSize++;
            }
        }

        //rebalance the heaps:
        while(maxSize > minSize + 1){
            minHeap.offer(maxHeap.poll());
            maxSize--;
            minSize++;
        }

        while(minSize > maxSize){
            maxHeap.offer(minHeap.poll());
            maxSize++;
            minSize--;
        }

        result[0] = midValue(maxHeap, minHeap, k);
        int left = 0;
        int l = 1;
        for(int right = k; right < nums.length; right++){
            buildHeap(maxHeap, minHeap, map, nums[left++], nums[right]);
            prune(maxHeap, map);
            prune(minHeap, map);
            result[l++] = midValue(maxHeap, minHeap, k);
        }

        return result;
    }

    private void buildHeap(Queue<Integer> maxHeap, Queue<Integer> minHeap, Map<Integer, Integer> map,  int left, int right){

        //remove the element using lazy deletion:
        
        //marking the outgoing element
        map.put(left, map.getOrDefault(left, 0) + 1);

        //adjust the sizes logically
        if(!maxHeap.isEmpty() && left <= maxHeap.peek()){
            //element logically removed from maxHeap
            maxSize--;
        }else{
            //logically removed from minHeap
            minSize--;
        }


        if(maxHeap.isEmpty() || right <= maxHeap.peek()){
            maxHeap.offer(right);
            maxSize++;

        }else{
            minHeap.offer(right);
            minSize++;
        }

        rebalance(maxHeap, minHeap, map);
    }

    private void prune(Queue<Integer> heap, Map<Integer, Integer> map){
        while(!heap.isEmpty()){
            int num = heap.peek();
            if(map.containsKey(num)){
                map.put(num, map.get(num) - 1);
                if(map.get(num) == 0) map.remove(num);//remove completely
                heap.poll();
            }else{
                break;
            }
        }
    }


    private void rebalance(Queue<Integer> maxHeap, Queue<Integer> minHeap, Map<Integer, Integer> map){
        if(maxSize > minSize + 1){
            minHeap.offer(maxHeap.poll());
            maxSize--;
            minSize++;
            prune(maxHeap, map);
        }else if(minSize > maxSize){
            maxHeap.offer(minHeap.poll());
            minSize--;
            maxSize++;
            prune(minHeap, map);
        }
    }

    private double midValue(Queue<Integer> maxHeap, Queue<Integer> minHeap, int k){

        double left = 0;
        double right = 0;
        double res = 0;

        if(k % 2 == 0){
            left = (double)maxHeap.peek();
            right = (double)minHeap.peek();
            res = left + (right - left) / 2;
        }else{
            res = (double)maxHeap.peek();
        }
        return res;
    }

    private void printHeap(Queue<Integer> maxHeap, Queue<Integer> minHeap){

        System.out.println();
        System.out.print("MaxHeap: ");
        while(!maxHeap.isEmpty()){
            System.out.print(" " + maxHeap.poll());
        }

        System.out.println();
        System.out.print("MinHeap: ");
        while(!minHeap.isEmpty()){
            System.out.print(" " + minHeap.poll());
        }
        System.out.println();
    }
}