class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) {
                maxHeap.offer(f);
            }
        }

        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp= new ArrayList<>();
            int taskProcessor= 0;

            for(int i=0;i < n+1; i++){
                if(!maxHeap.isEmpty()){
                    int rem= maxHeap.poll()-1;
                    if(rem>0){
                        temp.add(rem);
                    }
                    taskProcessor++;
                }
            }


            for(int rem: temp){
                maxHeap.offer(rem);
            }

            cycles+= maxHeap.isEmpty() ? taskProcessor: (n+1);
        }

return cycles;
        
    }
}
