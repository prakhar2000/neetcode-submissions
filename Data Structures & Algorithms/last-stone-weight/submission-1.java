class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone: stones){
            maxHeap.add(stone);
        }

        while(maxHeap.size()!=1 && !maxHeap.isEmpty()){
            int f= maxHeap.poll();
            int s= maxHeap.poll();

            if(f==s){
                continue;

            }else{
                int diff= Math.abs(f-s);

                maxHeap.add(diff);


            }
        }

if(maxHeap.isEmpty()){
    return 0;
}
        return maxHeap.poll();
        
    }
}
