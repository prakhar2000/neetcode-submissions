class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // bucket sort(only when the lnegth of array or         frequency in given and small)
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];

        for (int num : freq.keySet()) {
            int f = freq.get(num);

            if (buckets[f] == null) {
                buckets[f] = new ArrayList<>();
            }

            buckets[f].add(num);
        }

        int[] res = new int[k];
        int index=0;

        for (int i = buckets.length-1; i >=0 && index<k; i--) {
            if(buckets[i]!=null){
                for(int el: buckets[i]){
                    res[index++]= el;
                }
                if(index==k){
                    break;
                }
            }
        }

        return res;
        // //Using pq
        // Map<Integer, Integer> freq = new HashMap<>();

        // for (int num : nums) {
        //     freq.put(num, freq.getOrDefault(num, 0) + 1);
        // }

        // // 11223334
        // // 1-2, 2-2, 3-3, 4-1
        // //  pq->
        // Comparator<Integer> c = (a, b) -> freq.get(a) -          freq.get(b);
        // PriorityQueue<Integer> pq = new PriorityQueue<>( k,  c);

        // for (int num : freq.keySet()) {
        //     pq.offer(num);
        //     if (pq.size() > k) {
        //         pq.poll();
        //     }
        // }

        // int[] result = new int[k];
        // for (int i = 0; i < k; i++) {
        //     result[i] = pq.poll();
        // }

        // return result;
    }
}
