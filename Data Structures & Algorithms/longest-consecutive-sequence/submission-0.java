class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> hs= new HashSet<>();

        for(int num: nums){
            hs.add(num);
        }
        int max= 0;

        for (int num: hs){
            if(!hs.contains(num-1)){
                int currentlength=1;
                int currentNum= num;

                while(hs.contains(currentNum+1)){
                    currentNum++;
                    currentlength++;
                }
                max= Math.max(max, currentlength);
            }


        }
        return max;
    }
}
