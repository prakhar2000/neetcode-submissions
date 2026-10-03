class Solution {
    public int[] twoSum(int[] nums, int target) {
        //brute force(n^2) loop through each numeber for every number
    //     int[] res= new int[2];
    //     for(int i=0;i< nums.length; i++){
    //         for(int j=1; j< nums.length;j++){

    //             if(target-nums[i]==nums[j] && i!=j){
    //                 res[0]=i;
    //                 res[1]=j;

    //             }
    //         }
    //     }

    // return res;


    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i=0; i< nums.length; i++){
        int com= target-nums[i];

        if(hm.containsKey(com)){
            return new int[]{hm.get(com),i};
        }

        hm.put(nums[i], i);
    }
return new int[]{-1, -1};
        
    }
}
