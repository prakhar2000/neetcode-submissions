class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> hm= new HashMap<>();

        for(int n: nums){
            int temp= hm.getOrDefault(n, 0);
            if(temp==1)return true;
            temp++;
            hm.put(n, temp);
        }

return false;

        
    }
}